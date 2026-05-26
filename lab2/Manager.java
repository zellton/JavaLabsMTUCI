public class Manager extends Employee{

    private int teamSize;
    private double bonus;
    private String departmentName;

    @Override
    void DoItsJob(){
        System.out.println("Менеджер " + getName() + " планирует задачи для отдела " + departmentName);
    }

    @Override
    void showInfo(){
        super.showInfo();
        System.out.println("Размер команды: " + teamSize);
        System.out.println("Премия: " + bonus);
        System.out.println("Отдел: " + departmentName);
    }

    double calculateAnnualSalary(){
        return getSalary() * 12 + bonus;
    }

    Manager(){
        this("Неизвестно", 0.0, 0, 0, 0.0, "Неизвестно");
    }

    Manager(String name, double salary, int id, int teamSize, double bonus, String departmentName){
        super(name, salary, id);
        this.teamSize = teamSize;
        this.bonus = bonus;
        this.departmentName = departmentName;
    }

    public int getTeamSize(){
        return teamSize;
    }

    public void setTeamSize(int teamSize){
        this.teamSize = teamSize;
    }

    public double getBonus(){
        return bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

}
