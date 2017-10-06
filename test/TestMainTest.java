
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TestMainTest {

    @Test
    void CertainIntIsAchievable() {
        int CertainInt = 55;
        TestMain automatedTest1 = new TestMain();
        assertTrue(automatedTest1.getTemperature() - automatedTest1.getTemperature() + CertainInt == CertainInt);
    }

    @Test
    void higherThanMinimumTemperature() {
        int minimumTemp = -273;
        TestMain automatedTest1 = new TestMain();
        assertTrue(automatedTest1.getTemperature() >= minimumTemp);
    }

    @Test
    void lowerThanMaximumTemperature() {
        int maximumTemp = 500;
        TestMain automatedTest1 = new TestMain();
        assertTrue(automatedTest1.getTemperature() <= maximumTemp);
    }

    @Test
    void checkIfTwoCoordinates() {
        TestMain automatedTest1 = new TestMain();
        assertTrue(automatedTest1.getCoordinates().size() == 2);
    }

    @Test
    void checkIfLatitudeIsInCorrectFormat() {
        boolean areIntegers = true;
        TestMain automatedTest1 = new TestMain();
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
        TestMain automatedTest1 = new TestMain();
        String Longitude = automatedTest1.getCoordinates().get(1);
        String LongitudeWithoutPeriods = Longitude.replace(".", "");
        for (int i = 0; i < LongitudeWithoutPeriods.length(); i++) {
            if (LongitudeWithoutPeriods.charAt(i) < 48 | LongitudeWithoutPeriods.charAt(i) > 57) {
                areIntegers = false;
            }
        }
        assertTrue(Longitude.length() - Longitude.replace(".", "").length() == 2 & areIntegers);
    }
}
