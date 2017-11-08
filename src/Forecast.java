import java.util.ArrayList;

import com.google.gson.JsonArray;

import java.io.IOException;

import java.util.Scanner;

public class Forecast {

    private static Data currentData = new Data();
    private static JsonArray forecastWeatherData;
    private static ArrayList<Double> forecastTemps;
    private static String currentCountryCode;
    //private static String coordinates;

    public Forecast(String city) throws IOException{
        String ForecastAPIUrl = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&APPID=a01295b20312d5b0d9a59fece71a75cd";
        forecastWeatherData = currentData.getJsonData(ForecastAPIUrl).get("list").getAsJsonArray();
        currentCountryCode = currentData.getJsonData(ForecastAPIUrl).get("city").getAsJsonObject().get("country").getAsString();
        makeTemperatureList(); //Fills TallinnForecastTemps with temperatures from forecast data
    }

    ArrayList<Double> getForecastTemps() {
        return forecastTemps;
    }

    String getCurrentCountryCode() {
        return currentCountryCode;
    }



    Double findMinTemp() {
        Double current_min = forecastTemps.get(0);
        for (int i = 1; i < forecastTemps.size(); i++) {
            if (forecastTemps.get(i) < current_min) {
                current_min = forecastTemps.get(i);
            }
        }
        return current_min;
    }

    Double findMaxTemp() {
        Double current_min = forecastTemps.get(0);
        for (int i = 1; i < forecastTemps.size(); i++) {
            if (forecastTemps.get(i) > current_min) {
                current_min = forecastTemps.get(i);
            }
        }
        return current_min;
    }

    private void makeTemperatureList() {
        ArrayList<Double> tempList = new ArrayList<>();
        for (int i = 0; i < forecastWeatherData.size(); i++) {
            Double currentTemp = forecastWeatherData.get(i).getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsDouble();
            tempList.add(i, currentTemp);
        }
        forecastTemps = tempList;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("City to look for: ");
        Scanner cityInput = new Scanner(System.in);
        String cityName = cityInput.nextLine();
        try {
            Forecast testMain = new Forecast(cityName);
            System.out.println("List of forecast temperatures: " + forecastTemps);
            System.out.println("Forecast minimum: " + testMain.findMinTemp());
            System.out.println("Forecast maximum: " + testMain.findMaxTemp());
            System.out.println("Country code: " + currentCountryCode);
        } catch (Exception e) {
            System.out.println("City doesn't exist!");
        }
    }
}
