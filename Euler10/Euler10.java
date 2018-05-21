import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler10 {

    static long sieve(int limit) {
        Boolean[] primes = new Boolean[limit+1];
        primes[0] = false;
        primes[1] = false;
        for(int i = 2; i < primes.length;i++) {
            primes[i] = true;
        }

        for(int i = 0; i <= Math.sqrt(limit); i++) {
            if(primes[i]) {
                for(int j = i; j * i <= limit; j++) {
                    primes[j*i] = false;
                }
            }
        }
        long sum = 0;
        for(int i = 0; i < primes.length; i++) {
            if(primes[i]) sum += i;
        }
        return sum;
    }


    public static void main(String[] args) {
        int upper = 2000000;
        int test = 10;
        
        System.out.println(sieve(upper));
    }
}