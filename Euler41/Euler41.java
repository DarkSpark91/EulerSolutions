import java.util.ArrayList;

public class Euler41 {

    static boolean[] getPrimes(int n) {        
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int factor = 2; factor*factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }

        return isPrime;
    }

    static boolean isPandigital(int num) {
        String tmp = "" + num;
        for(int i = 0; i < tmp.length(); i++) {
            if(!tmp.contains(""+(i+1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int max = 0;
        boolean[] primes = getPrimes(123456789);

        for(int i = 0; i < primes.length; i++) {
            if(primes[i]) {
                if(isPandigital(i)) {
                    max = i;
                }
            }
        }

        System.out.println(max);
        
        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}