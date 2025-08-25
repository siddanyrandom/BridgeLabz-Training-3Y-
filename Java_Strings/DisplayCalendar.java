import java.util.Scanner;

public class DisplayCalendar {

    // Get month name
    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) return months[month - 1];
        else return "Invalid";
    }

    // Check leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Get number of days in month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (month == 2 && isLeapYear(year)) return 29;
        return days[month - 1];
    }

    // Get first day of month (0=Sunday, 1=Monday,...)
    public static int getFirstDay(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month)/12) - 2;
        int d0 = (1 + x + (31*m0)/12) % 7; // day=1
        return d0;
    }

    // Display calendar
    public static void displayCalendar(int month, int year) {
        System.out.println("     " + getMonthName(month) + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = getFirstDay(month, year);
        int numDays = getDaysInMonth(month, year);

        // Indentation for first week
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Print days
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%4d", day);
            if ((day + firstDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        displayCalendar(month, year);

        sc.close();
    }
}
