// Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie class
class PassengerBogie {
    String type;
    int capacity;

    PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }
}

// Main class
public class UC14CapacityCheck {

    public static void main(String[] args) {

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);   // ✅ valid
            System.out.println("Bogie created: " + b1.type + " - " + b1.capacity);

            PassengerBogie b2 = new PassengerBogie("AC", -10);      // ❌ invalid
            System.out.println("Bogie created: " + b2.type);

        } catch (InvalidCapacityException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Program continues safely...");
    }
}