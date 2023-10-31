import org.blackberry020.Reader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ReaderTest {
    @Test
    public void readerReadsTxtFileAndFoundsNothing() throws IOException{
        String filePath = "io_files/empty.txt";
        String expected = "";
        assertEquals(expected, Reader.read(filePath));
    }

    @Test
    public void readerReadsTxtFile() throws IOException {
        String filePath = "io_files/input.txt";
        String expected = "(3+4)*6-11\n";
        assertEquals(expected, Reader.read(filePath));
    }
}