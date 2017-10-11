import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestMain {

    final private static String tallinnForecastAPIUrl = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn&APPID=a01295b20312d5b0d9a59fece71a75cd";
    final private static String tallinnCurrentAPIUrl = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn,ee&appid=a01295b20312d5b0d9a59fece71a75cd";
    private static Double currentTallinnTemp;
    private static Data currentTallinnData = new Data();
    private static JsonArray forecastWeatherData;
    private static ArrayList<Double> TallinnForecastTemps;
    private static String currentCountryCode;
    //private static String coordinates;

    TestMain() throws IOException{
        currentTallinnTemp = currentTallinnData.getJsonData(tallinnCurrentAPIUrl).get("main").getAsJsonObject().get("temp").getAsDouble();
        forecastWeatherData = currentTallinnData.getJsonData(tallinnForecastAPIUrl).get("list").getAsJsonArray();
        makeTemperatureList(); //Fills TallinnForecastTemps with temperatures from forecast data
        currentCountryCode = currentTallinnData.getJsonData(tallinnCurrentAPIUrl).get("sys").getAsJsonObject().get("country").getAsString();
    }

    Double getTemperature() {
        return currentTallinnTemp;
    }

    ArrayList<Double> getForecastTemps() {
        return TallinnForecastTemps;
    }

    String getCurrentCountryCode() {
        return currentCountryCode;
    }

    Double findMinTemp() {
        Double current_min = TallinnForecastTemps.get(0);
        for (int i = 1; i < TallinnForecastTemps.size(); i++) {
            if (TallinnForecastTemps.get(i) < current_min) {
                current_min = TallinnForecastTemps.get(i);
            }
        }
        return current_min;
    }

    Double findMaxTemp() {
        Double current_min = TallinnForecastTemps.get(0);
        for (int i = 1; i < TallinnForecastTemps.size(); i++) {
            if (TallinnForecastTemps.get(i) > current_min) {
                current_min = TallinnForecastTemps.get(i);
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
        TallinnForecastTemps = tempList;
    }

    public static void main(String[] args) throws IOException {
        TestMain testMain = new TestMain();
        System.out.println(currentTallinnTemp);
        System.out.println(TallinnForecastTemps);
        System.out.println(testMain.findMinTemp());
        System.out.println(testMain.findMaxTemp());
        System.out.println(currentCountryCode);
    }

    /*
        void PullCoordinates() throws IOException {
        coordinates = currentTallinnData.getJsonData(tallinnCurrentAPIUrl).get("coord").getAsJsonObject().getAsString();
    }
     */
}
