import java.math.BigInteger;
import java.util.HashMap;

public class Euler30 {

    public static Long getLimit(int x) {
        long digits = 10, amount = (long)Math.pow(9, x), count = 1;
        while(digits < amount*count) {
            count++;
            digits *= 10;
        }
        return amount*count;
    }

    public static int[] getDigits(int num) {
        String tmp = Integer.toString(num);
        int[] result = new int[tmp.length()];
        for(int i = 0; i < tmp.length(); i++) {
            result[i] = Character.getNumericValue(tmp.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int power = 5;
        double[] powers = new double[10];
        for(int i = 0; i < 10; i++) {
            powers[i] = Math.pow(i, power);
        }
        Long limit = getLimit(power);
        long sum = 0;
        for(int i = 2; i <= limit; i++) {
            long currentSum = 0;
            int[] digits = getDigits(i);
            for(int digit : digits) {
                currentSum += powers[digit];
            }
            if(currentSum == i) {
                sum += currentSum;
            }
        }
        System.out.println(sum);
    }
}