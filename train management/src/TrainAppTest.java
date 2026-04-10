import java.util.Arrays;

public class UC17SortNames {

    public static void main(String[] args) {

        String[] bogieNames = {
                "Sleeper", "AC Chair", "First Class", "General", "Luxury"
        };

        // Sort using built-in method
        Arrays.sort(bogieNames);

        // Display result
        System.out.println("Sorted Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));
    }
}