public class CarRental {

    // Attributes of the CarRental class
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate; // A fixed daily rate for the car rental

    /**
     * Parameterized constructor to create a new CarRental object.
     * @param customerName The name of the customer.
     * @param carModel The model of the car being rented.
     * @param rentalDays The number of days for the rental.
     */
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        // Setting a default daily rate
        this.dailyRate = 50.0; 
    }

    /**
     * Calculates the total cost of the car rental.
     * @return The total cost as a double.
     */
    public double calculateTotalCost() {
        return this.rentalDays * this.dailyRate;
    }

    /**
     * Provides a string representation of the CarRental object.
     * @return A formatted string with the rental details.
     */
    @Override
    public String toString() {
        return "CarRental{" +
               "customerName='" + customerName + '\'' +
               ", carModel='" + carModel + '\'' +
               ", rentalDays=" + rentalDays +
               ", dailyRate=$" + String.format("%.2f", dailyRate) +
               '}';
    }

    /**
     * Main method to demonstrate the functionality of the CarRental class.
     */
    public static void main(String[] args) {
        // Create a new car rental object
        CarRental rental1 = new CarRental("John Doe", "Toyota Camry", 5);

        // Display the rental details
        System.out.println("Rental Details:");
        System.out.println(rental1);

        // Calculate and display the total cost
        double totalCost = rental1.calculateTotalCost();
        System.out.println("\nTotal Cost for the Rental: $" + String.format("%.2f", totalCost));
    }
}
