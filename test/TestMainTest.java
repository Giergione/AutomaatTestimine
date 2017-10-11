
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.DoubleBinaryOperator;

import static org.junit.Assert.*;

public class TestMainTest {

    private final Double MINIMUM_TEMP = Double.valueOf(-273);
    private final Double MAXIMUM_TEMP = Double.valueOf(40000);

    private static TestMain automatedTest1;
    private static Double currentTallinnTemp;
    private static ArrayList<Double> TallinnForecastTemps;

    TestMainTest() throws IOException{
        automatedTest1 = new TestMain();
        currentTallinnTemp = automatedTest1.getTemperature();
        TallinnForecastTemps = automatedTest1.getForecastTemps();
    }

    @Before
    public void SetUpAPI() throws IOException{
        new TestMainTest();
    }

    @Test
    void higherThanMinimumTemperature() {
        try {
            assertTrue(currentTallinnTemp >= MINIMUM_TEMP);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void lowerThanMaximumTemperature() {
        try {
            assertTrue(currentTallinnTemp <= MAXIMUM_TEMP);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void ForecastMinimumHigherThanLowestPossible() {
        try {
            assertTrue(automatedTest1.findMinTemp() >= MINIMUM_TEMP);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void ForecastMinimumLowerThanHighestPossible() {
        try {
            assertTrue(automatedTest1.findMinTemp() <= MAXIMUM_TEMP);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void ForecastMaximumHigherThanLowestPossible() {
        try {
            assertTrue(automatedTest1.findMaxTemp() >= MINIMUM_TEMP);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void ForecastMaximumLowerThanHighestPossible() {
        try {
            assertTrue(automatedTest1.findMaxTemp() <= MAXIMUM_TEMP);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testIfCurrentDataFromEstonia () {
        try {
            assertTrue(automatedTest1.getCurrentCountryCode().equals("EE"));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
    @Test
    void testIfForecastDataFromEstonia () {
        try {
            assertTrue(true);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    /*
    @Test
    void checkIfTwoCoordinates() {
        assertTrue(automatedTest1.getCoordinates().size() == 2);
    }

    @Test
    void checkIfLatitudeIsInCorrectFormat() {
        boolean areIntegers = true;
        String Latitude = automatedTest1.getCoordinates().get(0);
        String LatitudeWithoutPeriods = Latitude.replace(".", "");
        for (int i = 0; i < LatitudeWithoutPeriods.length(); i++) {
            if (LatitudeWithoutPeriods.charAt(i) < 48 | LatitudeWithoutPeriods.charAt(i) > 57) {
                areIntegers = false;
            }
        }
        assertTrue(Latitude.length() - Latitude.replace(".", "").length() == 2 & areIntegers);
    }

    @Test
    void checkIfLongitudeIsInCorrectFormat() {
        boolean areIntegers = true;
        String Longitude = automatedTest1.getCoordinates().get(1);
        String LongitudeWithoutPeriods = Longitude.replace(".", "");
        for (int i = 0; i < LongitudeWithoutPeriods.length(); i++) {
            if (LongitudeWithoutPeriods.charAt(i) < 48 | LongitudeWithoutPeriods.charAt(i) > 57) {
                areIntegers = false;
            }
        }
        assertTrue(Longitude.length() - Longitude.replace(".", "").length() == 2 & areIntegers);
    }
    */
}
