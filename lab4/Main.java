import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main (String[] args) throws CustomDivisionException {
        double a = 7;
        double b = 0;
        try {
            if (b == 0) { throw new CustomDivisionException("Деление на ноль невозможно; a = " + a + ", b = " + b); }
            System.out.println(a / b);
        } catch (CustomDivisionException e) {
            System.out.println(e.getMessage());
            try{
                Files.writeString(Paths.get("report.txt"), e.getMessage() + "\n", StandardOpenOption.APPEND, 
                StandardOpenOption.CREATE);
            } catch (IOException ex) {
                e.printStackTrace();
            }
        }
    }
}

class CustomDivisionException extends Exception {

    CustomDivisionException(String message) {
        super(message);
    }
}
