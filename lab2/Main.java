public class Main {
    public static void main(String[] args) {
        System.out.println("Начальное кол-во сотрудников: " + Employee.getCount());
        System.out.println("----------------------------------");

        Programmer dev = new Programmer("Алексей", 120000, 101, "Java", "Middle", true);
        Manager boss = new Manager("Марина", 150000, 201, 10, 30000, "Разработка");
        Administrator admin = new Administrator("Игорь", 90000, 301, 0, 5000, "IT-отдел", "Apollo-7", 10, true);

        System.out.println("\n=== ИНФОРМАЦИЯ О СОТРУДНИКАХ ===");

        dev.showInfo();
        dev.DoItsJob();
        dev.fixBugs(3);

        System.out.println("\n----------------------------------");

        boss.showInfo();
        boss.DoItsJob();
        System.out.println("Годовой доход менеджера: " + boss.calculateAnnualSalary());

        System.out.println("\n----------------------------------");

        admin.showInfo();
        admin.DoItsJob();
        admin.rebootServer();

        System.out.println("\n==================================");
        System.out.println("ИТОГО сотрудников создано: " + Employee.getCount());
    }
}
