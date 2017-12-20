package utility;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Data {

    /*
    Returns the JSON object from the URL input.
    forecast = true -> Forecast URL.
    forecast = false -> Current weather URL.
     */
    public JsonObject getJsonData(String cityName, boolean forecast) throws IOException {
        HttpURLConnection request = HttpUtility.makeHttpGetRequest(cityName, forecast);
        request.connect();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        request.disconnect();
        return root.getAsJsonObject();
    }
}
