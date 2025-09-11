import java.util.*;

public class CalendarDisplay {

    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) {
            return months[month - 1];
        }
        return "Invalid Month";
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        // Zeller's Congruence algorithm
        int q = 1; // day of month
        int m = month;
        int y = year;
        if (month == 1 || month == 2) {
            m += 12;
            y--;
        }
        int k = y % 100;
        int j = y / 100;
        int h = (q + (13*(m + 1))/5 + k + k/4 + j/4 + 5*j) % 7;
        // 0 = Saturday, 1 = Sunday, 2 = Monday, ..., 6 = Friday
        int day = ((h + 6) % 7); // convert so 0 = Sunday, 1 = Monday, ..., 6 = Saturday
        return day;
    }

    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int days = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);

        System.out.println("     " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    "); // 4 spaces for each day
        }

        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
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
