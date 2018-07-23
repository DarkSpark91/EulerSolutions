import java.math.BigInteger;

public class Euler25 {

    static int getFib(int digits) {
        BigInteger prev = BigInteger.ONE;
        BigInteger current = BigInteger.ONE;
        int term = 2;
        while(current.toString().length() < digits) {
            current = current.add(prev);
            prev = current.subtract(prev);
            term++;
        }
        return term;
    }

    public static void main(String[] args) {
        System.out.println(getFib(1000));
    }
}