import java.util.ArrayList;

public class Euler51 {

    static boolean[] primes;

    static void getPrimes(int n) {        
        primes = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }
        for (int factor = 2; factor*factor <= n; factor++) {
            if (primes[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    primes[(factor*j)] = false;
                }
            }
        }
    }

    public static boolean isfamily(String num, int family) {
        int count = 0;
        for(int i = 0; i < 10; i++) {
            String tmp = num.replace("*", ""+i);
            if(primes[Integer.parseInt(tmp)]) {
                count++;
            }
        }
        return count == family;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        getPrimes(1000000);

        for(int i = 1; i < 10; i += 2) {}
        
        System.out.println(isfamily("*2*3*3", 8));
        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}