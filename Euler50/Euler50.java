import java.util.ArrayList;

public class Euler50 {

    static boolean[] primes;

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



    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int limit = 1000000;

        primes = getPrimes(limit);

        int sum = 0;
        int num = 6;

        while((sum + num) < limit) {
            if(primes[num]) {
                sum += num;
            }
            num++;
        }

  
        System.out.println(sum);
        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}