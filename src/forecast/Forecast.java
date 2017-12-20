package forecast;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import utility.Data;

import java.io.IOException;

import java.util.List;
import java.util.Scanner;

public class Forecast {

    private static String forecastAPIUrl;
    private static Data currentData = new Data();
    private static JsonArray forecastWeatherData;
    private static ArrayList<Double> forecastTemps;
    private static String currentCountryCode;

    public Forecast(String city) throws IOException{
        forecastWeatherData = currentData.getJsonData(city, true).get("list").getAsJsonArray();
        currentCountryCode = currentData.getJsonData(city, true).get("city").getAsJsonObject().get("country").getAsString();
        makeTemperatureList(); //Fills TallinnForecastTemps with temperatures from forecast data
    }

    public ArrayList<Double> getForecastTemps() {
        return forecastTemps;
    }

    public String getCurrentCountryCode() {
        return currentCountryCode;
    }



    public Double findMinTemp() {
        Double current_min = forecastTemps.get(0);
        for (int i = 1; i < forecastTemps.size(); i++) {
            if (forecastTemps.get(i) < current_min) {
                current_min = forecastTemps.get(i);
            }
        }
        return current_min;
    }

    public Double findMaxTemp() {
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

    public List<Double> findThreeDayMinimums() throws IOException{
        ArrayList<Double> threeDayMinimums = new ArrayList<>();
        String date = forecastWeatherData.get(0).getAsJsonObject().get("dt_txt").getAsString().substring(0,10);
        double minimumTempOfTheDay = forecastWeatherData.get(0).getAsJsonObject().get("main").getAsJsonObject()
                .get("temp_min").getAsDouble();

        int day = 1; //which day in forecast
        for (int i = 0; i < forecastWeatherData.size(); i++) {
            String dateToLookAt = forecastWeatherData.get(i).getAsJsonObject().get("dt_txt")
                    .getAsString().substring(0,10);
            double minimumToLookAt = forecastWeatherData.get(i).getAsJsonObject().get("main").getAsJsonObject().get("temp_min")
                    .getAsDouble();
            if (dateToLookAt.equals(date)) {
                if (minimumTempOfTheDay > minimumToLookAt) {
                    minimumTempOfTheDay = minimumToLookAt;
                }
            } else {
                day++;
                date = dateToLookAt;
                threeDayMinimums.add(minimumTempOfTheDay);
                minimumTempOfTheDay = minimumToLookAt;
                if (day == 4) {
                    break;
                }
            }
        }
        return threeDayMinimums;
    }

    public List<Double> findThreeDayMaximums() throws IOException{
        ArrayList<Double> threeDayMaximums = new ArrayList<>();
        String date = forecastWeatherData.get(0).getAsJsonObject().get("dt_txt").getAsString().substring(0,10);
        double maximumTempOfTheDay = forecastWeatherData.get(0).getAsJsonObject().get("main").getAsJsonObject()
                .get("temp_max").getAsDouble();

        int day = 1; //which day in forecast
        for (int i = 0; i < forecastWeatherData.size(); i++) {
            String dateToLookAt = forecastWeatherData.get(i).getAsJsonObject().get("dt_txt")
                    .getAsString().substring(0,10);
            double maximumToLookAt = forecastWeatherData.get(i).getAsJsonObject().get("main").getAsJsonObject().get("temp_max")
                    .getAsDouble();
            if (dateToLookAt.equals(date)) {
                if (maximumTempOfTheDay < maximumToLookAt) {
                    maximumTempOfTheDay = maximumToLookAt;
                }
            } else {
                day++;
                date = dateToLookAt;
                threeDayMaximums.add(maximumTempOfTheDay);
                maximumTempOfTheDay = maximumToLookAt;
                if (day == 4) {
                    break;
                }
            }
        }
        return threeDayMaximums;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("City to look for: ");
        Scanner cityInput = new Scanner(System.in);
        String cityName = cityInput.nextLine();
        try {
            Forecast testMain = new Forecast(cityName);
            System.out.println("List of forecast temperatures (every 3 hours): " + forecastTemps);
            System.out.println("Forecast minimum: " + testMain.findMinTemp());
            System.out.println("Forecast maximum: " + testMain.findMaxTemp());
            System.out.println("Country code: " + currentCountryCode);
            System.out.println("3 day forecast minimums: " + testMain.findThreeDayMinimums());
            System.out.println("3 day forecast maximums: " + testMain.findThreeDayMaximums());
        } catch (Exception e) {
            System.out.println("City doesn't exist!");
        }
    }
}
