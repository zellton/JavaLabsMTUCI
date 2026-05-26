import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.List;

class Item {
    String name;
    int weight;

    Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}

class Warehouse {
    private final List<Item> items;               
    private int currentWeight = 0;                
    private static final int MAX_WEIGHT = 150;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition weightReached = lock.newCondition();

    Warehouse(List<Item> items) {
        this.items = new ArrayList<>(items);
    }
    
    public Item takeItem(String loaderName) throws InterruptedException {
        lock.lock(); 
        try {
            while (items.isEmpty()) {
                System.out.println(loaderName + " ждёт: склад пуст");
                notEmpty.await();
            }

            Item item = items.remove(0);

            if (currentWeight + item.weight > MAX_WEIGHT) {
                items.add(0, item);
                System.out.println(loaderName + 
                    " ждёт: суммарный вес достигнет " + MAX_WEIGHT + " кг");
                weightReached.await();
                return null; 
            }

            currentWeight += item.weight;
            System.out.println(loaderName + " взял товар: " + item.name +
                " (" + item.weight + " кг), итого: " + currentWeight + " кг");

            if (currentWeight >= MAX_WEIGHT || items.isEmpty()) {
                System.out.println("=== Набрано " + currentWeight +
                    " кг, все грузчики отправляются! ===");
                currentWeight = 0;
                weightReached.signalAll();
            }

            return item;
        } finally {
            lock.unlock();
        }
    }

    public boolean hasItems() {
        lock.lock();
        try {
            return !items.isEmpty();
        } finally {
            lock.unlock();
        }
    }
}

class Loader extends Thread {
    private Warehouse warehouse;

    Loader(String name, Warehouse warehouse) {
        super(name); 
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (warehouse.hasItems()) {
                warehouse.takeItem(getName());
                Thread.sleep(100);
            }
            System.out.println(getName() + " завершил работу.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Холодильник", 60));
        items.add(new Item("Диван", 50));
        items.add(new Item("Стиралка", 55));
        items.add(new Item("Телевизор", 30));
        items.add(new Item("Ящики", 20));

        Warehouse warehouse = new Warehouse(items);

        Loader l1 = new Loader("Грузчик-1", warehouse);
        Loader l2 = new Loader("Грузчик-2", warehouse);
        Loader l3 = new Loader("Грузчик-3", warehouse);

        l1.start();
        l2.start();
        l3.start();

        l1.join();
        l2.join();
        l3.join();

        System.out.println("Все товары перенесены!");
    }
}
