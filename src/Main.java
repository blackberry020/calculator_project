import java.io.IOException;

public class Main {

    /*
        mini tasks for the evening:
            import tests
            test file reading functions
            make reading with external libraries
            create an interface for reader
            create 3 classes Readers derived from Reader interface
     */
    public static void main(String[] args) throws IOException {
        String filePath = "input.json";

        System.out.println(Reader.read(filePath));
    }
}