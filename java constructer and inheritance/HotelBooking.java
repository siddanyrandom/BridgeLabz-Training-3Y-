public class HotelBooking {

    // Attributes of the HotelBooking class
    private String guestName;
    private String roomType;
    private int nights;

    /**
     * The default constructor.
     * Initializes a new HotelBooking object with standard default values.
     */
    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    /**
     * The parameterized constructor.
     * Initializes a new HotelBooking object with the provided values.
     * @param guestName The name of the guest.
     * @param roomType The type of room booked.
     * @param nights The number of nights for the stay.
     */
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    /**
     * The copy constructor.
     * Initializes a new HotelBooking object by copying the attributes from
     * an existing HotelBooking object.
     * @param otherBooking The HotelBooking object to be copied.
     */
    public HotelBooking(HotelBooking otherBooking) {
        this.guestName = otherBooking.guestName;
        this.roomType = otherBooking.roomType;
        this.nights = otherBooking.nights;
    }

    /**
     * Provides a string representation of the HotelBooking object.
     * @return A formatted string with the booking details.
     */
    @Override
    public String toString() {
        return "HotelBooking{" +
               "guestName='" + guestName + '\'' +
               ", roomType='" + roomType + '\'' +
               ", nights=" + nights +
               '}';
    }

    /**
     * Main method to demonstrate the functionality of the HotelBooking class.
     */
    public static void main(String[] args) {
        // Create a booking using the default constructor
        HotelBooking booking1 = new HotelBooking();
        System.out.println("Default Booking:");
        System.out.println(booking1);
        System.out.println("--------------------");

        // Create a booking using the parameterized constructor
        HotelBooking booking2 = new HotelBooking("Jane Doe", "Suite", 3);
        System.out.println("Parameterized Booking:");
        System.out.println(booking2);
        System.out.println("--------------------");

        // Create a new booking using the copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("Cloned Booking (created with copy constructor):");
        System.out.println(booking3);
        System.out.println("--------------------");

        // Let's modify the copied booking to prove it's a separate object.
        booking3.guestName = "Jane Smith";
        System.out.println("Cloned Booking after modification:");
        System.out.println(booking3);
        System.out.println("Original Parameterized Booking (unchanged):");
        System.out.println(booking2);
    }
}
