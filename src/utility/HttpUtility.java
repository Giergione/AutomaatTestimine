package utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtility {
    public static HttpURLConnection makeHttpGetRequest(String city, boolean forecast) throws IOException {
        URL url;
        if (forecast) {
            url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&APPID=a01295b20312d5b0d9a59fece71a75cd");
        } else {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=a01295b20312d5b0d9a59fece71a75cd");
        }
        return (HttpURLConnection) url.openConnection();
    }
}
