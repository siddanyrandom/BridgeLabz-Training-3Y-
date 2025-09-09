import java.util.Scanner;

public class FriendComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get ages
        System.out.println("Enter the age of Amar:");
        int amarAge = scanner.nextInt();
        System.out.println("Enter the age of Akbar:");
        int akbarAge = scanner.nextInt();
        System.out.println("Enter the age of Anthony:");
        int anthonyAge = scanner.nextInt();
        
        // Find the youngest friend
        System.out.println("\nFinding the youngest friend...");
        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            System.out.println("The youngest friend is Amar with age " + amarAge + ".");
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            System.out.println("The youngest friend is Akbar with age " + akbarAge + ".");
        } else {
            System.out.println("The youngest friend is Anthony with age " + anthonyAge + ".");
        }
        
        // Get heights
        System.out.println("\nEnter the height of Amar (in inches):");
        double amarHeight = scanner.nextDouble();
        System.out.println("Enter the height of Akbar (in inches):");
        double akbarHeight = scanner.nextDouble();
        System.out.println("Enter the height of Anthony (in inches):");
        double anthonyHeight = scanner.nextDouble();
        
        // Find the tallest friend
        System.out.println("\nFinding the tallest friend...");
        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            System.out.println("The tallest friend is Amar with a height of " + amarHeight + " inches.");
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            System.out.println("The tallest friend is Akbar with a height of " + akbarHeight + " inches.");
        } else {
            System.out.println("The tallest friend is Anthony with a height of " + anthonyHeight + " inches.");
        }
        
        scanner.close();
    }
}
