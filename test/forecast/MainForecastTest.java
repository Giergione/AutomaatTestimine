package forecast;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainForecastTest {

    private static final Double MINIMUM_TEMP = -273.0;
    private static final Double MAXIMUM_TEMP = 40000.0;

    private static Forecast automatedTest1;
    private static ArrayList<Double> ForecastTemps;

    MainForecastTest() throws IOException{
        automatedTest1 = new Forecast("Tallinn");
        ForecastTemps = automatedTest1.getForecastTemps();
    }

    @Before
    public void SetUpAPI() throws IOException{
        new MainForecastTest();
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
    void testIfForecastDataFromEstonia () {
        try {
            assertTrue(automatedTest1.getCurrentCountryCode().equals("EE"));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testIfForecastDataNotFromCanada () {
        try {
            assertFalse(automatedTest1.getCurrentCountryCode().equals("CA"));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testIfForecastDataFromCanada () {
        try {
            Forecast automatedTest2 = new Forecast("Toronto");
            assertTrue(automatedTest2.getCurrentCountryCode().equals("CA"));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testIfForecastMinimumsHaveThreeValues () {
        try {
            Forecast automatedTest2 = new Forecast("Toronto");
            assertTrue(automatedTest2.findThreeDayMinimums().size() == 3);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testIfForecastMaximumsHaveThreeValues () {
        try {
            Forecast automatedTest2 = new Forecast("Toronto");
            assertTrue(automatedTest2.findThreeDayMaximums().size() == 3);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testIfForecastMinimumsAreLowerThanMaximums () {
        try {
            Forecast automatedTest2 = new Forecast("Toronto");
            assertTrue(automatedTest2.findThreeDayMinimums().get(2) < automatedTest2.findThreeDayMaximums().get(2));
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}
