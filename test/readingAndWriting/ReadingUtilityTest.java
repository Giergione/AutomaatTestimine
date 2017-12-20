package readingAndWriting;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReadingUtilityTest {

    final private static String fileToRead = "src\\readingAndWriting\\input.txt";

    @Test
    public void testIfReadingTheRightCities() throws Exception {
        List<String> readInput = new ReadingUtility().readCityInput();
        FileReader file = new FileReader(fileToRead);
        BufferedReader reader = new BufferedReader(file);
        List<String> input = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            input.add(line);
            line = reader.readLine();
        }
        try {
            assertEquals(readInput, input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}