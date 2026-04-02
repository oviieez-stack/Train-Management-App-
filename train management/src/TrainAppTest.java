import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;

public class TrainAppTest {

    List<Bogie> getBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 70)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertFalse(result.stream().anyMatch(b -> b.capacity == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertFalse(result.stream().anyMatch(b -> b.capacity < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 75),
                new Bogie("First Class", 60)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 10)
                .collect(Collectors.toList());

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = new ArrayList<Bogie>().stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getBogies();

        List<Bogie> result = original.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(3, original.size());
    }
}