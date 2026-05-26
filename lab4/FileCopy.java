import java.io.*;


public class FileCopy {
    public static void main (String[] args){
        String SourcePath = "source.txt";
        String TargetPath = "target.txt";

        try (FileInputStream source = new FileInputStream(SourcePath)){
            try (FileOutputStream target = new FileOutputStream(TargetPath)) {
                int i;
                while ((i = source.read()) != -1){
                    target.write(i);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при работе с конечным файлом");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Изначальный файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с начальным файлом");
        }
    }
}
