public class Vehicle {

    // Instance variables: unique to each Vehicle object
    private String ownerName;
    private String vehicleType;

    // Class variable: shared among all Vehicle objects.
    // It is a fixed fee for all vehicles.
    private static double registrationFee = 250.00;

    /**
     * Parameterized constructor for the Vehicle class.
     * Initializes a new vehicle with the provided owner and type.
     * @param ownerName The name of the vehicle's owner.
     * @param vehicleType The type of the vehicle (e.g., "Car", "Motorcycle").
     */
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    /**
     * An instance method to display the details of a single vehicle.
     * This method accesses both instance and class variables.
     */
    public void displayVehicleDetails() {
        System.out.println("------------------------------------");
        System.out.println("Owner: " + this.ownerName);
        System.out.println("Vehicle Type: " + this.vehicleType);
        System.out.println("Registration Fee: $" + String.format("%.2f", Vehicle.registrationFee));
        System.out.println("------------------------------------");
    }

    /**
     * A static method to update the registration fee for all vehicles.
     * This method can be called without creating a Vehicle object.
     * @param newFee The new registration fee.
     */
    public static void updateRegistrationFee(double newFee) {
        Vehicle.registrationFee = newFee;
        System.out.println("\nSuccessfully updated registration fee to $" + String.format("%.2f", newFee));
    }

    /**
     * Main method to demonstrate the functionality of the Vehicle class.
     */
    public static void main(String[] args) {
        // Create the first vehicle
        Vehicle vehicle1 = new Vehicle("Alice", "Sedan");
        System.out.println("--- Initial Vehicle Details ---");
        vehicle1.displayVehicleDetails();

        // Create the second vehicle
        Vehicle vehicle2 = new Vehicle("Bob", "Motorcycle");
        vehicle2.displayVehicleDetails();

        // Update the registration fee using the static method
        Vehicle.updateRegistrationFee(300.50);

        // Display the vehicle details again to show the updated registration fee
        System.out.println("\n--- Vehicle Details After Update ---");
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
