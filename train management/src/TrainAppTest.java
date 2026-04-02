import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainApp {

    // 🔹 Logic method (important for testing)
    static int calculateTotal(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // 🔹 Main method
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        int total = calculateTotal(bogies);

        System.out.println("Total Seating Capacity: " + total);
    }
}

// 🔹 Test Class (same file)
class TrainAppTest {

    List<Bogie> getBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        assertEquals(152, TrainApp.calculateTotal(getBogies()));
    }

    @Test
    void testReduce_SingleBogie() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72));
        assertEquals(72, TrainApp.calculateTotal(list));
    }

    @Test
    void testReduce_EmptyList() {
        assertEquals(0, TrainApp.calculateTotal(new ArrayList<>()));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int total = TrainApp.calculateTotal(getBogies());
        assertEquals(72 + 56 + 24, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = getBogies();
        TrainApp.calculateTotal(original);
        assertEquals(3, original.size());
    }
}