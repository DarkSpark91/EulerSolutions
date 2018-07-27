import java.util.ArrayList;
import java.util.Arrays;

public class Euler46 {

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

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList<Integer> primes = getPrimes(10000);
        int num = 3;

        boolean isNotGoldbach = true;
        while(isNotGoldbach) {
            isNotGoldbach = false;
            num++;

            if(num % 2 == 0 || primes.contains(num)) {
                isNotGoldbach = true;
                continue;
            }
            for(int i = 0; primes.get(i) < num; i++) {
                double d = num - primes.get(i);
                d /= 2;
                double tmp = Math.sqrt(d);
                if(tmp == Math.round(tmp)) {
                    isNotGoldbach = true;
                    break;
                }
            }
        }

        System.out.println(num);

        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}