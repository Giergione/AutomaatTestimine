import java.io.IOException;

import java.util.Scanner;

public class CurrentWeather {

    private static Double currentTemp;
    private static Data currentData = new Data();
    private static String currentCountryCode;
    //private static String coordinates;

    public CurrentWeather(String cityName) throws IOException {
        String currentAPIUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=a01295b20312d5b0d9a59fece71a75cd";
        currentTemp = currentData.getJsonData(currentAPIUrl).get("main").getAsJsonObject().get("temp").getAsDouble();
        currentCountryCode = currentData.getJsonData(currentAPIUrl).get("sys").getAsJsonObject().get("country").getAsString();
    }

    Double getTemperature() {
        return currentTemp;
    }

    String getCurrentCountryCode() {
        return currentCountryCode;
    }


    public static void main(String[] args) throws IOException {
        System.out.println("City to look for: ");
        Scanner cityInput = new Scanner(System.in);
        String cityName = cityInput.nextLine();
        try {
            CurrentWeather mainCurrent = new CurrentWeather(cityName);
            System.out.println(currentTemp);
            System.out.println(currentCountryCode);
        } catch (Exception e) {
            System.out.println("City doesn't exist!");
        }
    }
}
