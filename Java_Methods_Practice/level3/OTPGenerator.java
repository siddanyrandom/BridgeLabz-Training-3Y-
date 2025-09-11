import java.util.*;

public class OTPGenerator {

    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000; // 6-digit number from 100000 to 999999
    }

    public static boolean areUnique(int[] otps) {
        Set<Integer> set = new HashSet<>();
        for (int otp : otps) {
            if (!set.add(otp)) return false; // duplicate found
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otpArray = new int[10];

        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        System.out.println("Generated OTPs: " + Arrays.toString(otpArray));
        System.out.println("All OTPs unique: " + areUnique(otpArray));
    }
}
