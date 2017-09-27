import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AutomatedTest1 {

    public int getTemperature() {
        return 23;
    }

    public List<String> getCoordinates() {
        ArrayList<String> coordinates = new ArrayList<>(2);
        coordinates.add(0, "12.34.56");
        coordinates.add(1, "65.43.21");
        return coordinates;
    }
}
