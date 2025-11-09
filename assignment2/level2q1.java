import java.util.Scanner;
class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double n1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double n2 = sc.nextDouble();
        double add = n1 + n2;
        double sub = n1 - n2;
        double mul = n1 * n2;
        double div = n1 / n2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + n1 + " and " + n2 + " is " + add + ", " + sub + ", " + mul + ", and " + div);
    }
}
