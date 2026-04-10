import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    int capacity;

    Bogie(int capacity) {
        this.capacity = capacity;
    }
}

public class PerformanceUC13 {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Create sample data (large dataset)
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie((int)(Math.random() * 100)));
        }

        // 🔥 LOOP APPROACH
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // 🔥 STREAM APPROACH
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ✅ OUTPUT
        System.out.println("Loop Count: " + loopResult.size());
        System.out.println("Stream Count: " + streamResult.size());

        System.out.println("Loop Time (ns): " + loopTime);
        System.out.println("Stream Time (ns): " + streamTime);
    }
}