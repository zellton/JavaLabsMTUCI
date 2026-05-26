public class Administrator extends Manager{

    private String serverName;
    private int accessLevel;
    private boolean OnShift;

    @Override
    void DoItsJob(){
        System.out.println("Администратор " + getName() + " проверяет логи сервера " + serverName);
    }

    @Override
    void showInfo(){
        super.showInfo();
        System.out.println("Название сервера: " + serverName);
        System.out.println("Уровень доступа: " + accessLevel);
        System.out.println("На дежурстве: " + OnShift);
    }

    void rebootServer(){
        System.out.println("Перезагружаем сервер!");
    }

    Administrator(){
        this("Неизвестно", 0.0, 0, 0, 0.0, "Неизвестно", "Неизвестно", 0, false);
    }

    Administrator(String name, double salary, int id, int teamSize, double bonus, String departmentName, String serverName, int accessLevel, boolean isOnShift){
        super(name, salary, id, teamSize, bonus, departmentName);
        this.serverName = serverName;
        this.accessLevel = accessLevel;
        this.OnShift = isOnShift;
    }

    public String getServerName(){
        return serverName;
    }

    public void setServerName(String serverName){
        this.serverName = serverName;
    }

    public int getAccessLevel(){
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel){
        this.accessLevel = accessLevel;
    }

    public boolean isOnShift(){
        return OnShift;
    }

    public void setOnShift(boolean OnShift){
        this.OnShift = OnShift;
    }
}
