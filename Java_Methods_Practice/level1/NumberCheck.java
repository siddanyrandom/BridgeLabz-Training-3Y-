import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int result = checkNumber(number);

        if (result == 1) {
            System.out.println("Positive Number");
        } else if (result == -1) {
            System.out.println("Negative Number");
        } else {
            System.out.println("Zero");
        }

        sc.close();
    }

    public static int checkNumber(int num) {
        if (num > 0) {
            return 1;
        } else if (num < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
