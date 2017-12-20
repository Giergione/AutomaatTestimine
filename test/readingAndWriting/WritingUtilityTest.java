package readingAndWriting;

import org.junit.Test;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WritingUtilityTest {

    final private static String fileToRead = "src\\readingAndWriting\\input.txt";


    //Test Reading Utility first.
    @Test
    public void testIfWritingWorksCorrectly() throws Exception {
        //Run reading and writing utility once to observe the results.
        ReadingAndWriting readingAndWriting = new ReadingAndWriting();
        readingAndWriting.ReadAndWrite(new ReadingUtility(), new WritingUtility());

        FileReader inputFile = new FileReader(fileToRead);
        BufferedReader inputFileReader = new BufferedReader(inputFile);
        String input = inputFileReader.readLine();

        FileReader writtenFile = new FileReader("src\\forecastData\\" + input + ".txt");
        BufferedReader writtenFileReader = new BufferedReader(writtenFile);
        String output = writtenFileReader.readLine();

        try {
            Assert.assertEquals(input, output.substring(11));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}