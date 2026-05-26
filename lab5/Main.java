import java.util.regex.*;

public class Main {


    static void task1() {
        System.out.println("=== Задание 1: Поиск чисел ===");
        String text = "I have 3 cats, 10.5 kg of food, and 200 dollars left";

        if (text == null || text.isEmpty()) {
            System.out.println("Ошибка: текст не может быть пустым или null");
            return;
        }

        System.out.println("Текст: " + text);

        try {
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);

            System.out.println("Найденные числа:");
            int count = 0;
            while (matcher.find()) {
                System.out.println("  " + matcher.group());
                count++;
            }
            if (count == 0) System.out.println("  Числа не найдены.");
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
        System.out.println();
    }

    static void task2() {
        System.out.println("=== Задание 2: Проверка паролей ===");
        String[] passwords = {
                "Secure1Pass",   
                "short1A",       
                "nouppercase1",  
                "NoDigitsHere",  
                "ValidPass9OK",  
                null             
        };

        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";

        try {
            Pattern pattern = Pattern.compile(regex);
            for (String pwd : passwords) {
                if (pwd == null) {
                    System.out.printf("  %-15s → Ошибка: пароль не может быть null%n", "null");
                    continue;
                }
                Matcher matcher = pattern.matcher(pwd);
                String status = matcher.matches() ? "ВЕРНЫЙ" : "НЕВЕРНЫЙ";
                System.out.printf("  %-15s → %s%n", pwd, status);
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
        System.out.println();
    }

    static void task3() {
        System.out.println("=== Задание 3: Строчная → Заглавная ===");
        String text = "camelCase and myVariableName and helloWorld test";

        if (text == null || text.isEmpty()) {
            System.out.println("Ошибка: текст не может быть пустым или null");
            return;
        }

        System.out.println("Исходный текст: " + text);

        try {
            Pattern pattern = Pattern.compile("([a-z])([A-Z])");
            Matcher matcher = pattern.matcher(text);
            String result = matcher.replaceAll("!$1$2!");

            System.out.println("После замены:   " + result);
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
        System.out.println();
    }

    static void task4() {
        System.out.println("=== Задание 4: Проверка IP-адресов ===");
        String[] addresses = {
                "192.168.1.1",
                "256.0.0.1",
                "10.0.0",
                "0.0.0.0",
                "255.255.255.255",
                "192.168.1.999"
        };

        String octet = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)";
        String regex  = "^" + octet + "\\." + octet + "\\." + octet + "\\." + octet + "$";

        try {
            Pattern pattern = Pattern.compile(regex);
            for (String ip : addresses) {
                if (ip == null) {
                    System.out.printf("  %-20s → Ошибка: IP не может быть null%n", "null");
                    continue;
                }
                Matcher matcher = pattern.matcher(ip);
                String status = matcher.matches() ? "ВЕРНЫЙ" : "НЕВЕРНЫЙ";
                System.out.printf("  %-20s → %s%n", ip, status);
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
        System.out.println();
    }

    static void task5() {
        System.out.println("=== Задание 5: Слова на заданную букву ===");
        String text   = "The quick brown fox jumps over the lazy dog near the tree";
        char   letter = 't';
        System.out.println("Текст:          " + text);
        System.out.println("Ищем букву:     '" + letter + "'");

        if (text == null || text.isEmpty()) {
            System.out.println("Ошибка: текст не может быть пустым или null");
            return;
        }

        String regex = "\\b["
                + Character.toLowerCase(letter)
                + Character.toUpperCase(letter)
                + "]\\w*";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            System.out.println("Найденные слова:");
            int count = 0;
            while (matcher.find()) {
                System.out.printf("  [pos %2d] %s%n", matcher.start(), matcher.group());
                count++;
            }
            if (count == 0) System.out.println("  Слова не найдены.");
            else System.out.println("Всего найдено: " + count);
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }
}
