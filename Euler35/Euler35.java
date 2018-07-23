import java.awt.List;
import java.util.ArrayList;

public class Euler35 {

    static final int LIMIT = 1_000_000;
    static boolean[] isPrime;

    static void getPrimes(int n) {
        isPrime = new boolean[n+1];
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
    }

    public static ArrayList<Integer> getInts(int num) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        while(num > 0) {
            ints.add(num%10);
            num /= 10;
        }
        return ints;
    }

    public static boolean isCircularPrime(int num) {
        if(!isPrime[num]) {
            return false;
        }
        ArrayList<Integer> ints = getPerms(num);
        for(Integer rot : ints) {
            if(!isPrime[rot]) {
                return false;
            }
        }
        return true;
    }

    public static int getLength(int num) {
        int count = 0;
        int length = 1;
        num = Math.abs(num);
        while(num > length) {
            length *= 10;
            count++;
        }
        return count;
    }

    public static ArrayList<Integer> getPerms(int num) {
        //todo find get perms
        ArrayList<Integer> result = new ArrayList<Integer>();
        double size = getLength(num);
        for(int i = 0; i < size; i++) {
            int tmp = num % 10;
            num /= 10;
            num += (tmp * (int)Math.pow(10.0, size-1));
            result.add(num);
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getPrimes(LIMIT);
        int count = 0;

        for(int i = 0; i < LIMIT; i++) {
            if(isCircularPrime(i)) {
                count++;
            }
        }

        System.out.println(count);
        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}