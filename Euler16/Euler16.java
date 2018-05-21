import java.math.BigInteger;

public class Euler16 {

    static BigInteger getPow(int num) {
        return BigInteger.valueOf(2).shiftLeft(num-1);
    }

    static long sum(BigInteger num) {
        long total = 0;
        String tmp = num.toString();
        for(int i = 0; i < tmp.length(); i++) {
            total += Character.getNumericValue(tmp.charAt(i));
        }
        return total;
    }

    public static void main(String[] args) {
        int num = 1000;
        System.out.println(sum(getPow(num)));
    }
}