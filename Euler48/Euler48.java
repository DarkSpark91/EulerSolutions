import java.math.BigInteger;

public class Euler48 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        BigInteger sum = BigInteger.ZERO;
        BigInteger mod = BigInteger.valueOf(10_000_000_000L);

        for(int i = 1; i < 1000; i++) {
            BigInteger tmp = BigInteger.valueOf(i);
            sum = sum.add(tmp.modPow(tmp, mod)).mod(mod);
        }

        System.out.println(sum);

        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}