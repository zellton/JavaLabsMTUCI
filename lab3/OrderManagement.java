import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name     = name;
        this.quantity = quantity;
        this.price    = price;
    }

    public String getName()  { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " x" + quantity + " — " + price + " руб.";
    }
}


class Order {
    private int orderNumber;
    private List<Product> products;
    private String deliveryAddress;
    private double totalCost;

    public Order(int orderNumber, String deliveryAddress) {
        this.orderNumber     = orderNumber;
        this.deliveryAddress = deliveryAddress;
        this.products        = new ArrayList<>();
        this.totalCost       = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalCost += product.getPrice() * product.getQuantity();
    }

    public int getOrderNumber()        { return orderNumber; }
    public List<Product> getProducts() { return products; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public double getTotalCost()       { return totalCost; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Заказ №").append(orderNumber).append(" ===\n");
        sb.append("Адрес доставки: ").append(deliveryAddress).append("\n");
        sb.append("Товары:\n");
        for (Product p : products) {
            sb.append("  - ").append(p).append("\n");
        }
        sb.append("Итого: ").append(totalCost).append(" руб.");
        return sb.toString();
    }
}


class OrderStorage {
    private HashMap<Integer, Order> orders;

    public OrderStorage() {
        this.orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        if (orders.containsKey(order.getOrderNumber())) {
            System.out.println("Заказ №" + order.getOrderNumber() + " уже существует.");
            return;
        }
        orders.put(order.getOrderNumber(), order);
        System.out.println("Заказ №" + order.getOrderNumber() + " добавлен.");
    }

    public Order getOrder(int orderNumber) {
        Order order = orders.get(orderNumber);
        if (order == null) {
            System.out.println("Заказ №" + orderNumber + " не найден.");
        }
        return order;
    }

    public boolean removeOrder(int orderNumber) {
        if (orders.remove(orderNumber) != null) {
            System.out.println("Заказ №" + orderNumber + " удалён.");
            return true;
        }
        System.out.println("Заказ №" + orderNumber + " не найден.");
        return false;
    }

    public void printAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("Хранилище заказов пусто.");
            return;
        }
        Collection<Order> allOrders = orders.values();
        for (Order order : allOrders) {
            System.out.println(order);
            System.out.println();
        }
    }

    public int size()        { return orders.size(); }
    public boolean isEmpty() { return orders.isEmpty(); }
}


public class OrderManagement {
    public static void main(String[] args) {

        OrderStorage storage = new OrderStorage();

        
        Order order1 = new Order(1001, "Москва, ул. Ленина, д. 5");
        order1.addProduct(new Product("Ноутбук", 1, 75000.0));
        order1.addProduct(new Product("Мышь",    2,  1500.0));

        Order order2 = new Order(1002, "Санкт-Петербург, пр. Невский, д. 10");
        order2.addProduct(new Product("Смартфон", 1, 45000.0));
        order2.addProduct(new Product("Чехол",    1,   800.0));

        Order order3 = new Order(1003, "Казань, ул. Баумана, д. 3");
        order3.addProduct(new Product("Клавиатура", 1, 3500.0));


        System.out.println("=== Вставка заказов ===");
        storage.addOrder(order1);
        storage.addOrder(order2);
        storage.addOrder(order3);
        storage.addOrder(order1); 
        System.out.println("Всего заказов: " + storage.size() + "\n");

      
        System.out.println("=== Поиск заказа №1002 ===");
        Order found = storage.getOrder(1002);
        if (found != null) System.out.println(found);

        System.out.println("\n=== Поиск несуществующего №9999 ===");
        storage.getOrder(9999);


        System.out.println("\n=== Удаление заказа №1001 ===");
        storage.removeOrder(1001);
        storage.removeOrder(1001); 
        System.out.println("Всего заказов: " + storage.size());


        System.out.println("\n=== Все оставшиеся заказы ===");
        storage.printAllOrders();
    }
}
