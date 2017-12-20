package readingAndWriting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ReadingUtility {

    final private static String fileToRead = "src\\readingAndWriting\\input.txt";

    List<String> readCityInput() throws Exception {
        FileReader file = new FileReader(fileToRead);
        BufferedReader reader = new BufferedReader(file);

        ArrayList<String> input = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null) {
            input.add(line);
            line = reader.readLine();
        }
        return input;
    }
}
