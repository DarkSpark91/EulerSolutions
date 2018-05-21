import java.util.ArrayList;

public class Euler07 {

    static boolean isPrime(ArrayList<Integer> primes, int num) {
        for(Integer prime : primes) {
            if(num % prime == 0) {
                return false;
            }
        }
        return true;
    }

    static int getprime(int term) {
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        int count = 1;
        for(int i = 3; count < term ;i += 2) {
            if(isPrime(primes, i)) {
                primes.add(i);
                count++;
            }
        }
        return primes.get(primes.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(getprime(10001));
    }
}