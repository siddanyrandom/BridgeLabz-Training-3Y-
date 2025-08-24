import java.util.Scanner;

public class StudentVotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define an array of 10 elements
        int[] ages = new int[10];

        // Taking user input
        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }

        // Checking eligibility
        System.out.println("\nVoting Eligibility Results:");
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];

            if (age < 0) {
                System.out.println("Invalid age entered for student " + (i + 1));
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }

        sc.close();
    }
}
