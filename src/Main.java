import java.util.HashMap;
import java.util.Map;

public class Main {

    // Inventory class responsible for managing room availability
    static class RoomInventory {

        private HashMap<String, Integer> inventory;

        // Constructor initializes the inventory
        public RoomInventory() {
            inventory = new HashMap<>();
        }

        // Register a room type with available count
        public void registerRoomType(String roomType, int count) {
            inventory.put(roomType, count);
        }

        // Get availability of a specific room type
        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        // Book a room (decrease availability)
        public boolean bookRoom(String roomType) {
            int available = getAvailability(roomType);

            if (available > 0) {
                inventory.put(roomType, available - 1);
                return true;
            }
            return false;
        }

        // Release a room (increase availability)
        public void releaseRoom(String roomType) {
            int available = getAvailability(roomType);
            inventory.put(roomType, available + 1);
        }

        // Display inventory
        public void displayInventory() {
            System.out.println("\nCurrent Room Inventory:");

            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    // Main method (system entry point)
    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Booking System.");
        System.out.println("Version 3.0");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Register room types
        inventory.registerRoomType("Single", 10);
        inventory.registerRoomType("Double", 5);
        inventory.registerRoomType("Suite", 2);

        // Display inventory
        inventory.displayInventory();

        // Book a room
        System.out.println("\nBooking a Single room...");
        boolean booked = inventory.bookRoom("Single");

        if (booked) {
            System.out.println("Room booked successfully.");
        } else {
            System.out.println("Room not available.");
        }

        // Show updated inventory
        inventory.displayInventory();

        // Release a room
        System.out.println("\nReleasing a Single room...");
        inventory.releaseRoom("Single");

        // Final inventory state
        inventory.displayInventory();
    }
}