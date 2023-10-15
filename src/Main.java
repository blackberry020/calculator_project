import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream("input.txt")) {
            System.out.println("successfully opened the file");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}