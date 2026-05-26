import java.util.*;

public class SalesTracker {
    private LinkedHashMap<String, Integer> sales = new LinkedHashMap<>();
    private double totalRevenue = 0;
    private Map<String, Double> prices = new HashMap<>();

    public void addSale(String product, double price) {
        sales.put(product, sales.getOrDefault(product, 0) + 1);
        prices.put(product, price);
        totalRevenue += price;
    }

    public void printSales() {
        System.out.println("--- Список проданных товаров (в порядке добавления) ---");
        sales.forEach((product, count) -> 
            System.out.println(product + ": " + count + " шт."));
    }

    public void printStats() {
        System.out.println("Общая сумма продаж: " + totalRevenue);
        
        String popular = null;
        int maxSales = 0;
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                popular = entry.getKey();
            }
        }
        System.out.println("Наиболее популярный товар: " + (popular != null ? popular : "нет"));
    }

    public static void main(String[] args) {
        SalesTracker shop = new SalesTracker();
        shop.addSale("Молоко", 80.0);
        shop.addSale("Хлеб", 45.0);
        shop.addSale("Молоко", 80.0);
        shop.addSale("Кофе", 300.0);

        shop.printSales();
        shop.printStats();
    }
}
