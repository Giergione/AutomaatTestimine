import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class ReadingAndWritingTest {
    final private static String fileToRead = "src\\input.txt";
    final private static String fileToWrite = "src\\output.txt";

    @Test
    public void testIfReadingTheRightCity() throws Exception {
        String readInput = new ReadingAndWriting().readCityInput();
        FileReader file = new FileReader(fileToRead);
        BufferedReader reader = new BufferedReader(file);
        String input = "";
        String line = reader.readLine();
        while (line != null) {
            input += line;
            line = reader.readLine();
        }
        try {
            assertEquals(readInput, input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testIfWritingWorksCorrectly() throws Exception {
        ReadingAndWriting readingAndWriting = new ReadingAndWriting();
        String readInput = readingAndWriting.readCityInput();
        readingAndWriting.writeOutput(readInput);
        BufferedReader brTest = new BufferedReader(new FileReader(fileToWrite));
        String firstLine = brTest.readLine();
        try {
            assertEquals("City name: " + readInput, firstLine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}