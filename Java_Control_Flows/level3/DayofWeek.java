public class DayOfWeek {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int k = y % 100;
        int j = y / 100;

        int f = d + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 + 5 * j;
        int dayOfWeek = f % 7;

        // Convert Zeller output to 0=Sunday, 1=Monday...
        int result = (dayOfWeek + 6) % 7;
        System.out.println(result);
    }
}
