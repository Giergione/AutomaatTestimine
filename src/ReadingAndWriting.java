import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;


public class ReadingAndWriting {


    final private static String fileToRead = "src\\input.txt";
    final private static String fileToWrite = "src\\output.txt";

    public static void main(String[] args) throws Exception{
        try {
            ReadingAndWriting readingAndWriting = new ReadingAndWriting();
            readingAndWriting.writeOutput(readingAndWriting.readCityInput());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

     String readCityInput() throws Exception {
        FileReader file = new FileReader(fileToRead);
        BufferedReader reader = new BufferedReader(file);

        String input = "";
        String line = reader.readLine();
        while (line != null) {
            input += line;
            line = reader.readLine();
        }
        return input;
    }

    void writeOutput(String input) throws Exception {

        PrintWriter outputStream = new PrintWriter(fileToWrite);
        String[] dataToWrite = new String[5];
        CurrentWeather currentWeather = new CurrentWeather(input);
        Forecast forecast = new Forecast(input);

        dataToWrite[0] = "City name: " + input;
        dataToWrite[1] = "Current temperature: " + currentWeather.getTemperature();
        dataToWrite[2] = "3 day forecast min: " + forecast.findMinTemp();
        dataToWrite[3] = "3 day forecast max: " + forecast.findMaxTemp();
        dataToWrite[4] = "Country code: " + currentWeather.getTemperature();

        for (String line : dataToWrite) {
            outputStream.println(line);
        }
        outputStream.close();
    }
}
