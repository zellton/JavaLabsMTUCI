import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "text.txt";
        File file = new File(filePath);
        Map<String, Integer> wordMap = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zа-я0-9]", "");
                if (!word.isEmpty()) {
                    wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
            return;
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordMap.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        System.out.println("Топ-10 самых частых слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getKey() + ": " + list.get(i).getValue());
        }
    }
}
