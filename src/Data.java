import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

class Data {

    JsonObject getJsonData(String Url) throws IOException {
        HttpURLConnection request = HttpUtility.makeHttpGetRequest(Url);
        request.connect();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        request.disconnect();
        return root.getAsJsonObject();
    }
}
