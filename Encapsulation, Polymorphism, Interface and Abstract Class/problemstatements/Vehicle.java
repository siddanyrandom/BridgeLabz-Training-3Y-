import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }
    public abstract double calculateRentalCost(int days);
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: $" + rentalRate);
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String policyNumber;
    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }
    public double calculateRentalCost(int days) { return getRentalRate() * days; }
    public double calculateInsurance() { return 0.1 * getRentalRate() * 30; }
    public String getInsuranceDetails() { return "Car Insurance Policy: " + policyNumber; }
}

class Bike extends Vehicle implements Insurable {
    private String policyNumber;
    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }
    public double calculateRentalCost(int days) { return getRentalRate() * days; }
    public double calculateInsurance() { return 0.05 * getRentalRate() * 30; }
    public String getInsuranceDetails() { return "Bike Insurance Policy: " + policyNumber; }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate) { super(vehicleNumber, "Truck", rentalRate); }
    public double calculateRentalCost(int days) { return getRentalRate() * days * 1.2; }
}

public class VehicleRentalDemo {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C101", 50, "CAR12345"));
        vehicles.add(new Bike("B202", 20, "BIKE6789"));
        vehicles.add(new Truck("T303", 100));
        for (Vehicle v : vehicles) {
            v.displayDetails();
            double rentalCost = v.calculateRentalCost(5);
            System.out.println("Rental Cost for 5 days: $" + rentalCost);
            if (v instanceof Insurable ins) {
                System.out.println(ins.getInsuranceDetails());
                System.out.println("Insurance Cost: $" + ins.calculateInsurance());
            }
            System.out.println("-------------------------");
        }
    }
}
