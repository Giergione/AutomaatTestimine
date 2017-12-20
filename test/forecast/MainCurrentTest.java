package forecast;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import utility.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainCurrentTest {
    private static final Double MINIMUM_TEMP = 0.0;
    private static final Double MAXIMUM_TEMP = 40000.0;

    private static CurrentWeather automatedTest1;
    private static Double currentTemp;

    MainCurrentTest() throws IOException {
        automatedTest1 = new CurrentWeather("Tallinn", new Data());
        currentTemp = automatedTest1.getTemperature();
    }


    @Before
    public void SetUpAPI() throws IOException {
        new MainCurrentTest();
    }

    @Test
    void higherThanMinimumTemperature() {
        try {
            assertTrue(currentTemp >= MINIMUM_TEMP);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void lowerThanMaximumTemperature() {
        try {
            assertTrue(currentTemp <= MAXIMUM_TEMP);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testIfCurrentDataFromEstonia() {
        try {
            assertTrue(automatedTest1.getCurrentCountryCode().equals("EE"));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }


    @Test
    void testIfCurrentDataNotFromLatvia() {
        try {
            assertFalse(automatedTest1.getCurrentCountryCode().equals("LV"));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testIfForecastDataFromCanada() {
        try {
            CurrentWeather automatedTest2 = new CurrentWeather("Toronto", new Data());
            assertTrue(automatedTest2.getCurrentCountryCode().equals("CA"));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testIfCoordinatesInRightFormat() {
        try {
            CurrentWeather automatedTest2 = new CurrentWeather("Toronto", new Data());
            String[] items = automatedTest2.getCurrentCountryCoords().split(",");
            double lon = Double.parseDouble(items[0].substring(5));
            double lat = Double.parseDouble(items[1].substring(6));
            assertTrue(true);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}
