import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AutomatedTest1Test {

    @Test
    public void testTemperature() {

    }

    @Test
    public void testCoordinates() {
        AutomatedTest1 automatedTest1 = new AutomatedTest1();
        ArrayList<String> toTest = new ArrayList<>();
        toTest.add(0,"TestX");
        toTest.add(1,"TestY");
        assertArrayEquals(toTest, automatedTest1.getCoordinates());

        }
    }
}