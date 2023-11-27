import org.blackberry020.read.StringReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ReaderTest {
    @Test
    public void readerReadsTxtFileAndFindsNothing() throws IOException{
        String filePath = "io_files/empty.txt";
        String expected = "";
        assertEquals(expected, StringReader.read(filePath));
    }

    @Test
    public void readerReadsTxtFile() throws IOException {
        String filePath = "io_files/input.txt";
        String expected = "(3+4)*6-11";
        assertEquals(expected, StringReader.read(filePath));
    }
}