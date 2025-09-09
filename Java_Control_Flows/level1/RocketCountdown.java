import java.util.Scanner;

public class RocketCountdown {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to begin the countdown: ");
        int counter = scanner.nextInt();

        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
        
        System.out.println("Blastoff!");

        scanner.close();
    }
}
