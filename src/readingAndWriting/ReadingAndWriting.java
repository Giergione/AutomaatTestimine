package readingAndWriting;

import forecast.CurrentWeather;
import forecast.Forecast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;


public class ReadingAndWriting {


    public static void main(String[] args) throws Exception{
        ReadingAndWriting readingAndWriting = new ReadingAndWriting();
        readingAndWriting.ReadAndWrite(new ReadingUtility(), new WritingUtility());
    }

    public void ReadAndWrite(ReadingUtility readingUtility, WritingUtility writingUtility) {
        try {
            writingUtility.writeOutput(readingUtility.readCityInput());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
