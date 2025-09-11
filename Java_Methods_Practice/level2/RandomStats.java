import java.util.*;

public class RandomStats {

    public int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            // 4-digit number: 1000 to 9999 inclusive
            arr[i] = (int) (Math.random() * 9000) + 1000;
        }
        return arr;
    }

    public double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;
        for (int n : numbers) {
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        double avg = (double) sum / numbers.length;
        return new double[]{avg, min, max};
    }

    public static void main(String[] args) {
        RandomStats rs = new RandomStats();
        int[] randomNumbers = rs.generate4DigitRandomArray(5);
        double[] stats = rs.findAverageMinMax(randomNumbers);

        System.out.println("Generated 4-digit numbers: " + Arrays.toString(randomNumbers));
        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum: " + (int) stats[1]);
        System.out.println("Maximum: " + (int) stats[2]);
    }
}
