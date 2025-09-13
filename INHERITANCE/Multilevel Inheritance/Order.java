
class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }

    void displayDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

public class Main {
    public static void main(String[] args) {
        Order o1 = new Order(101, "2025-09-13");
        ShippedOrder o2 = new ShippedOrder(102, "2025-09-12", "TRK12345");
        DeliveredOrder o3 = new DeliveredOrder(103, "2025-09-10", "TRK54321", "2025-09-13");

        o1.displayDetails();
        System.out.println();
        o2.displayDetails();
        System.out.println();
        o3.displayDetails();
    }
}
```
