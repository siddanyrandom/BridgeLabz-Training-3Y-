import java.util.ArrayList;
import java.util.List;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per unit: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.1;
    }

    public String getDiscountDetails() {
        return "Vegetarian discount: 10%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 2.0 * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    public String getDiscountDetails() {
        return "Non-Vegetarian discount: 5%";
    }
}

public class FoodDeliveryDemo {
    public static void processOrder(List<FoodItem> items) {
        for (FoodItem item : items) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            System.out.println("Total Price: $" + total);
            if (item instanceof Discountable d) {
                double discount = d.applyDiscount();
                System.out.println(d.getDiscountDetails());
                System.out.println("Price after discount: $" + (total - discount));
            }
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 10, 2));
        order.add(new NonVegItem("Chicken Biryani", 15, 1));
        processOrder(order);
    }
}
