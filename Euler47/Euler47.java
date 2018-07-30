import java.util.ArrayList;

public class Euler47 {

    static ArrayList<Integer> primes;

    static ArrayList<Integer> getPrimes(int n) {        
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            primes.add(i);
        }
        for (int factor = 2; factor*factor <= n; factor++) {
            if (primes.get(factor - 2) != 0) {
                for (int j = factor; factor*j <= n; j++) {
                    primes.set((factor*j) - 2, 0);
                }
            }
        }
        primes.removeIf(p -> p == 0);
        return primes;
    }

    public static int getDistinctPrimes(int num) {
        int count = 0;
        int rem = num;
        for(int i = 0; i < primes.size(); i++) {
            if(primes.get(i) * primes.get(i) > num) {
                return count + 1;
            }
            boolean primefactor = false;

            while(rem % primes.get(i) == 0) {
                primefactor = true;
                rem /= primes.get(i);
            }

            if(primefactor) {
                count++;
            }

            if(rem == 1) {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        primes = getPrimes(100000);
        int num = 0;
        int limit = 4;
        int count = 0;
        int firstNumber = 0;

        while(count < limit) {
            num++;
            if(getDistinctPrimes(num) >= limit) {
                count++;
            } else {
                firstNumber = num + 1;
                count = 0;
            }
        }


        System.out.println(firstNumber);
        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}