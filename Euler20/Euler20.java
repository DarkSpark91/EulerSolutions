import java.math.BigInteger;

public class Euler20 {
    static BigInteger factorial(BigInteger num) {
        if(num.equals(BigInteger.ONE))
            return BigInteger.ONE;
        return num.multiply(factorial(num.subtract(BigInteger.ONE)));
    }

    static BigInteger sum(BigInteger num) {
        if(num.compareTo(BigInteger.TEN) == -1) {
            return num;
        }
        return num.mod(BigInteger.TEN).add(sum(num.divide(BigInteger.TEN)));
    }

    public static void main(String[] args) {
        System.out.println(sum(factorial(BigInteger.valueOf(100))));
    }
}