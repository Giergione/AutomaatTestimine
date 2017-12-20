package forecast;

import com.google.gson.JsonObject;
import utility.Data;

import java.io.IOException;

import java.util.Scanner;

public class CurrentWeather {

    private  JsonObject jsonObject;
    private Data data;
    private boolean CurrentWeather = false;
    private String cityName;
    //private static String coordinates;

    public CurrentWeather(String cityName, Data data) throws IOException {
        this.data = data;
        this.cityName = cityName;
        GetJsonObjectFromData();
    }

    public void GetJsonObjectFromData() throws IOException {
        this.jsonObject = this.data.getJsonData(cityName, CurrentWeather);
    }


    public Double getTemperature() {
        return jsonObject.get("main").getAsJsonObject().get("temp").getAsDouble();
    }

    public String getCurrentCountryCode() {
        return jsonObject.get("sys").getAsJsonObject().get("country").getAsString();
    }

    public String getCurrentCountryCoords() {
        return "lon: " + jsonObject.get("coord").getAsJsonObject()
                .get("lon").getAsString() + ", lat: " + jsonObject.get("coord").getAsJsonObject()
                .get("lat").getAsString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("City to look for: ");
        Scanner cityInput = new Scanner(System.in);
        String cityName = cityInput.nextLine();
        try {
            CurrentWeather mainCurrent = new CurrentWeather(cityName, new Data());
            System.out.println(mainCurrent.getTemperature());
            System.out.println(mainCurrent.getCurrentCountryCode());
            System.out.println(mainCurrent.getCurrentCountryCoords());
        } catch (Exception e) {
            System.out.println("City doesn't exist!");
        }
    }
}
