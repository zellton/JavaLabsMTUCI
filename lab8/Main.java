import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DataProcessor {
}


class FilterProcessor {
    
    @DataProcessor
    public Stream<String> filterShortWords(Stream<String> stream) {
        return stream.filter(s -> s.length() > 3);
    }
}

class TransformProcessor {

    @DataProcessor
    public Stream<String> toUpperCase(Stream<String> stream) {
        return stream.map(s -> {
            System.out.println("Слово '" + s + "' обрабатывается потоком: " + Thread.currentThread().getName());
            return s.toUpperCase();
        });
    }
}

class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }
    
    public void loadData(String source) throws Exception {
        data = Files.readAllLines(Paths.get(source));
    }

    @SuppressWarnings("unchecked")
    public void processData() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<List<String>> future = executorService.submit(() -> {
            Stream<String> stream = data.parallelStream();

            for (Object processor : processors) {
                for (Method method : processor.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(DataProcessor.class)) {
                        try {
                            stream = (Stream<String>) method.invoke(processor, stream);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return stream.collect(Collectors.toList());
        });

        data = future.get();
        executorService.shutdown();
    }

    public void saveData(String destination) throws Exception {
        Files.write(Paths.get(destination), data);
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            Files.write(Paths.get("input.txt"), Arrays.asList("cat", "apple", "dog", "banana", "kiwi", "sun"));

            DataManager manager = new DataManager();

            manager.registerDataProcessor(new FilterProcessor());
            manager.registerDataProcessor(new TransformProcessor());

            System.out.println("Загрузка данных...");
            manager.loadData("input.txt");

            System.out.println("Обработка данных в параллельном режиме...");
            manager.processData();

            System.out.println("Сохранение данных...");
            manager.saveData("output.txt");

            System.out.println("Готово! Результат обработки:");
            Files.readAllLines(Paths.get("output.txt")).forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
