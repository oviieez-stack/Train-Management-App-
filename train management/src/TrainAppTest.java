import java.util.Arrays;
import java.util.Scanner;

public class UC19BinarySearch {

    public static void main(String[] args) {

        String[] bogieIds = {"BG309","BG101","BG550","BG205","BG412"};

        // 🔥 Step 1: Sort array (important)
        Arrays.sort(bogieIds);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        // 🔥 Binary Search
        while (low <= high) {
            int mid = (low + high) / 2;

            int result = key.compareTo(bogieIds[mid]);

            if (result == 0) {
                found = true;
                break;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Result
        if (found) {
            System.out.println("Bogie Found!");
        } else {
            System.out.println("Bogie Not Found!");
        }

        sc.close();
    }
}