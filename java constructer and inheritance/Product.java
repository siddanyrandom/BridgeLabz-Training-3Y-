public class Product {

    // Instance variables: unique to each object
    private String productName;
    private double price;

    // Class variable: shared among all objects of this class
    private static int totalProducts = 0;

    /**
     * Parameterized constructor for the Product class.
     * Initializes a new product and increments the total number of products.
     * @param productName The name of the product.
     * @param price The price of the product.
     */
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        // Increment the class variable whenever a new object is created
        totalProducts++;
    }

    /**
     * An instance method to display the details of a single product.
     */
    public void displayProductDetails() {
        System.out.println("Product Name: " + this.productName);
        System.out.println("Price: $" + String.format("%.2f", this.price));
    }

    /**
     * A static method to display the total number of products created.
     * This method can be called without creating an instance of the class.
     */
    public static void displayTotalProducts() {
        System.out.println("Total number of products created: " + totalProducts);
    }

    /**
     * Main method to demonstrate the functionality of the Product class.
     */
    public static void main(String[] args) {
        // Display the initial total number of products (should be 0)
        System.out.println("--- Initial Status ---");
        Product.displayTotalProducts();
        System.out.println("----------------------");

        // Create the first product
        Product product1 = new Product("Laptop", 1200.00);
        System.out.println("\n--- Product 1 Details ---");
        product1.displayProductDetails();

        // Create the second product
        Product product2 = new Product("Smartphone", 800.00);
        System.out.println("\n--- Product 2 Details ---");
        product2.displayProductDetails();

        // Display the updated total number of products
        System.out.println("\n--- Updated Status ---");
        Product.displayTotalProducts();
    }
}
