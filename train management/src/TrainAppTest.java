import java.util.*;

class Bogie {
    String type;
    String cargo;

    Bogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class SafetyCheckUC12 {

    public static void main(String[] args) {

        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Open", "Coal"),
                new Bogie("Box", "Grain")
        );

        // Safety rule check using stream
        boolean isSafe = bogies.stream().allMatch(b ->
                !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum")
        );

        if (isSafe) {
            System.out.println("Train is SAFE");
        } else {
            System.out.println("Train is UNSAFE");
        }
    }
}