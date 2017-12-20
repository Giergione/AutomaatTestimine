package readingAndWriting;

import forecast.CurrentWeather;
import forecast.Forecast;
import utility.Data;

import java.io.PrintWriter;
import java.util.List;

public class WritingUtility {

    void writeOutput(List<String> input) throws Exception {

        for (String countryName : input) {
            CurrentWeather currentWeather = new CurrentWeather(countryName, new Data());
            Forecast forecast = new Forecast(countryName);

            PrintWriter writer = new PrintWriter("src\\forecastData\\" + countryName + ".txt", "UTF-8");
            writer.println("City name: " + countryName);
            writer.println("Current temperature: " + currentWeather.getTemperature());
            writer.println("3 day forecast minimums: " + forecast.findThreeDayMinimums());
            writer.println("3 day forecast maximums: " + forecast.findThreeDayMaximums());
            writer.println("Country code: " + currentWeather.getCurrentCountryCode());
            writer.println("Country coords: " + currentWeather.getCurrentCountryCoords());
            writer.close();
        }
    }
}
