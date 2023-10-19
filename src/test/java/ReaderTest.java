import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ReaderTest {
    @Test
    public void readerReadsTxtFileAndFoundsNothing() {

        String filePath = "io_files/empty.txt";

        try {
            String expected = "";
            assertEquals(expected, Reader.read(filePath));
        }
        catch(IOException e) { //?
            fail("must not throw any exception. Exception message: " + e.getMessage());
        }
    }

    @Test
    public void readerReadsTxtFile() {

        String filePath = "io_files/input.txt";

        try {
            String expected = "(3+4)*6-11\n";
            assertEquals(expected, Reader.read(filePath));
        }
        catch(IOException e) { //?
            fail("must not throw any exception. Exception message: " + e.getMessage());
        }
    }
}