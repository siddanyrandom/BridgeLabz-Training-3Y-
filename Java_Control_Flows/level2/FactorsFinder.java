import java.util.Scanner;

public class FactorsFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number <= 0 || number >= 100) {
            System.out.println("Enter a positive integer less than 100");
        } else {
            int counter = number - 1;
            while (counter > 1) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter--;
            }
        }
        sc.close();
    }
}
