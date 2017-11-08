
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainCurrentTest {
    private static final Double MINIMUM_TEMP = -273.0;
    private static final Double MAXIMUM_TEMP = 40000.0;

    private static CurrentWeather automatedTest1;
    private static Double currentTemp;

    MainCurrentTest() throws IOException {
        automatedTest1 = new CurrentWeather("Tallinn");
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
            CurrentWeather automatedTest2 = new CurrentWeather("Toronto");
            assertTrue(automatedTest2.getCurrentCountryCode().equals("CA"));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}
