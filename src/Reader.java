import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static String read(String filePath) {

        StringBuilder builder = new StringBuilder();

        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {

            String str;

            while ((str = buffer.readLine()) != null) {
                builder.append(str).append("\n");
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return builder.toString();
    }
}
