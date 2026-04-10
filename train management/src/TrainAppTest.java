import java.util.Scanner;

public class UC20SearchValidation {

    public static boolean searchBogie(String[] bogieIds, String key) {

        // 🔥 Fail-fast check
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available to search!");
        }

        // Linear Search (you can also use binary)
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101", "BG205", "BG309"};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        try {
            boolean found = searchBogie(bogieIds, key);

            if (found) {
                System.out.println("Bogie Found!");
            } else {
                System.out.println("Bogie Not Found!");
            }

        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        sc.close();
    }
}