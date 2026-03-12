abstract class Room {

    private int beds;
    private int size;
    private double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getRoomType();

    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType());
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq ft");
        System.out.println("Price: $" + price);
    }
}

class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 200, 100);
    }

    @Override
    public String getRoomType() {
        return "Single Room";
    }
}

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 350, 180);
    }

    @Override
    public String getRoomType() {
        return "Double Room";
    }
}

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 600, 350);
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Booking System");
        System.out.println("Version 2.0");

        // Room objects created
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailable = 5;
        int doubleRoomAvailable = 3;
        int suiteRoomAvailable = 2;

        System.out.println("=== Hotel Room Availability ===\n");

        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailable);
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailable);
        System.out.println();

        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailable);
        System.out.println();

        System.out.println("Application Terminated.");
    }
}