import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kasutaja on 14.09.2017.
 */
public class AutomatedTest1 {

    public static void main(String[] args) {
        AutomatedTest1 automatedTest1 = new AutomatedTest1();
        System.out.println(automatedTest1.getCoordinates());
    }

    public BigDecimal getTemperature() {
        return null;
    }

    public List<String> getCoordinates() {
        ArrayList<String> coordinates = new ArrayList<>(2);
        coordinates.add(0, "testX");
        coordinates.add(1, "testY");
        return coordinates;
    }
}
