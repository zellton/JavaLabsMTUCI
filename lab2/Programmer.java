public class Programmer extends Employee{

    private String mainLanguage;
    private String category;
    private boolean hasProject;

    @Override
    void DoItsJob(){
        System.out.println("Программист " + getName() + " пишет код на " + mainLanguage);
    }

    @Override
    void showInfo(){
        super.showInfo();
        System.out.println("Основной язык: " + mainLanguage);
        System.out.println("Категория: " + category);
        System.out.println("Сейчас участвует в проекте: " + hasProject);
    }

    void fixBugs(){
        System.out.println("Фиксим баги");
    }

    void fixBugs(int bugs){
        System.out.println("Фиксим столько багов: " + bugs);
    }

    Programmer(){
        this("Неизвестно", 0.0, 0, "Неизвестно", "Неизвестно", false);
    }

    Programmer(String name, double salary, int id, String mainLanguage, String category, boolean hasProject){
        super(name, salary, id);
        this.mainLanguage = mainLanguage;
        this.category = category;
        this.hasProject = hasProject;
    }

    public String getMainLanguage(){
        return mainLanguage;
    }

    public void setMainLanguage(String mainLanguage){
        this.mainLanguage = mainLanguage;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public boolean isHasProject(){
        return hasProject;
    }

    public void setHasProject(boolean hasProject){
        this.hasProject = hasProject;
    }
}
