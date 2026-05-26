public abstract class Employee {

    private String name;
    private double salary;
    private int id;
    private static int count = 0;

    void showInfo(){
        System.out.println("Имя: " + name);
        System.out.println("Зарплата: " + salary);
        System.out.println("Идентификационный номер: " + id);
    }

    Employee(){
        this("Неизвестно", 0.0, 0);
    }

    Employee(String name, double salary, int id){
        count++;
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public static int getCount(){
        return count;
    }

    abstract void DoItsJob();
}
