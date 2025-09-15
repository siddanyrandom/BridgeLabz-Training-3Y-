import java.util.ArrayList;
import java.util.List;

abstract class Vehicle2 {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public double getRatePerKm() { return ratePerKm; }
    public void setRatePerKm(double ratePerKm) { this.ratePerKm = ratePerKm; }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

class Car extends Vehicle implements GPS {
    private String location;
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    public double calculateFare(double distance) { return getRatePerKm() * distance; }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}

class Bike extends Vehicle implements GPS {
    private String location;
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    public double calculateFare(double distance) { return getRatePerKm() * distance * 0.9; }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}

class Auto extends Vehicle implements GPS {
    private String location;
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    public double calculateFare(double distance) { return getRatePerKm() * distance * 1.1; }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}

public class RideHailingDemo {
    public static void calculateFares(List<Vehicle> vehicles, double distance) {
        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: $" + v.calculateFare(distance));
            if (v instanceof GPS gps) {
                gps.updateLocation("Downtown");
                System.out.println("Current Location: " + gps.getCurrentLocation());
            }
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C101", "Alice", 10));
        vehicles.add(new Bike("B202", "Bob", 8));
        vehicles.add(new Auto("A303", "Charlie", 6));

        calculateFares(vehicles, 15);
    }
}
