```java
import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (₹" + price + ")";
    }
}

class Order {
    private static int nextId = 1;
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(Customer customer) {
        this.orderId = nextId++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public int getOrderId() { return orderId; }

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotal() {
        double total = 0;
        for (Product p : products) total += p.getPrice();
        return total;
    }

    public void showOrderDetails() {
        System.out.println("Order #" + orderId + " by " + customer.getName());
        for (Product p : products) {
            System.out.println("  • " + p);
        }
        System.out.println("Total: ₹" + getTotal());
        System.out.println();
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() { return name; }

    public void placeOrder(Order o) {
        orders.add(o);
        System.out.println(name + " placed Order #" + o.getOrderId());
    }

    public void showOrderHistory() {
        System.out.println("Order history for " + name + ":");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 75000);
        Product p2 = new Product("Headphones", 3000);
        Product p3 = new Product("Mouse", 1200);
        Product p4 = new Product("Keyboard", 2500);

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        Order o1 = new Order(c1);
        o1.addProduct(p1);
        o1.addProduct(p2);

        Order o2 = new Order(c1);
        o2.addProduct(p3);

        Order o3 = new Order(c2);
        o3.addProduct(p2);
        o3.addProduct(p4);

        c1.placeOrder(o1);
        c1.placeOrder(o2);
        c2.placeOrder(o3);

        c1.showOrderHistory();
        c2.showOrderHistory();
    }
}
```
