package exercise;

import com.dataStruct_algorithm.exercise.TxtReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author pi
 * @date 2021/07/01 16:44:32
 **/
public class TxtReaderTest {

    @Test
    public void should_create_txt_reader_obj() throws Exception {
        String file = "";
        TxtReader txtReader = new TxtReader(file);
    }

    @Test
    public void should_read_txt_from_file() throws Exception {
        String filePath = "/home/pi/Documents/test.txt";
        String expectedFirstLine = "111test\n";

        TxtReader txtReader = new TxtReader(filePath);
        String result = txtReader.readFile();

        Assertions.assertEquals(expectedFirstLine,result);
    }

    @Test
    public void should_read_txt_line_by_line() throws Exception {
        String filePath = "/home/pi/Documents/test.txt";
        String expectedLineString = "No2.line";
        TxtReader txtReader = new TxtReader(filePath);
        List<String> txtFileContents = txtReader.readFileLineByLine();

        Assertions.assertEquals(expectedLineString,txtFileContents.get(1));
    }
}
