package forecast;

import com.google.gson.JsonObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import utility.Data;
import utility.HttpUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class APIMock {

    private CurrentWeather currentWeather;

    @Mock
    private Data mockedData;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() throws IOException {
        mockedData = mock(Data.class);
        currentWeather = new CurrentWeather("Saue", mockedData);
    }

    @Test
    public void openWeatherAPICallRequest() throws IOException {
        verify(mockedData).getJsonData("Saue", false);
    }
}