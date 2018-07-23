import java.math.BigInteger;
import java.util.HashSet;

public class Euler29 {

    public static void main(String[] args) {
        HashSet set = new HashSet<BigInteger>();
        int limit = 100;
        for(int a = 2; a <= limit; a++) {
            for(int b = 2; b <= limit; b++) {
                set.add(BigInteger.valueOf(a).pow(b));
            }
        }
        System.out.println(set.size());
    }
}