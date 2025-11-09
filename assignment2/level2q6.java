import java.util.Scanner;
class QuotientAndRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int quotient = a / b;
        int remainder = a % b;
        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + a + " and " + b);
    }
}
