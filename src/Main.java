import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // Reservation class representing a booking request
    static class Reservation {
        private String guestName;
        private String roomType;
        private int nights;

        public Reservation(String guestName, String roomType, int nights) {
            this.guestName = guestName;
            this.roomType = roomType;
            this.nights = nights;
        }

        public String getGuestName() {
            return guestName;
        }

        public String getRoomType() {
            return roomType;
        }

        public int getNights() {
            return nights;
        }

        @Override
        public String toString() {
            return "Guest: " + guestName +
                    ", Room Type: " + roomType +
                    ", Nights: " + nights;
        }
    }

    // Booking Request Queue Manager
    static class BookingRequestQueue {

        private Queue<Reservation> requestQueue;

        public BookingRequestQueue() {
            requestQueue = new LinkedList<>();
        }

        // Submit booking request
        public void submitRequest(Reservation reservation) {
            requestQueue.offer(reservation);
            System.out.println("Request added to queue: " + reservation.getGuestName());
        }

        // View next request without removing
        public Reservation peekNextRequest() {
            return requestQueue.peek();
        }

        // Remove next request for processing
        public Reservation pollNextRequest() {
            return requestQueue.poll();
        }

        // Display all queued requests
        public void displayQueue() {
            System.out.println("\nCurrent Booking Request Queue:");
            for (Reservation r : requestQueue) {
                System.out.println(r);
            }
        }

        public boolean isEmpty() {
            return requestQueue.isEmpty();
        }
    }

    // Main method (Simulation)
    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Booking System.");
        System.out.println("Version 5.0");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guests submit booking requests
        Reservation r1 = new Reservation("Alice", "Deluxe", 2);
        Reservation r2 = new Reservation("Bob", "Suite", 3);
        Reservation r3 = new Reservation("Charlie", "Standard", 1);

        bookingQueue.submitRequest(r1);
        bookingQueue.submitRequest(r2);
        bookingQueue.submitRequest(r3);

        // Display queue
        bookingQueue.displayQueue();

        // Peek next request
        System.out.println("\nNext request to process: " + bookingQueue.peekNextRequest());
    }
}