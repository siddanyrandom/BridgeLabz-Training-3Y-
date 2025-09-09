import java.util.Scanner;

public class RocketCountdown2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to begin the countdown: ");
        int counter = scanner.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        
        System.out.println("Blastoff!");

        scanner.close();
    }
}
