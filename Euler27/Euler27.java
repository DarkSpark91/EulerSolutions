public class Euler27 {

    static boolean isPrime(long n) {
        if(n < 2) {
            return false;
        } else if(n <= 3)
            return true;
        else if(n%2 == 0 && n%3 == 0) {
            return false;
        }
        long sqrt = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrt; i += 6) {
            if(n%(i+1) == 0 || n%(i-1) == 0) {
                return false;
            }
        }
        return true;
    }

    static int countPrimes(int a, int b) {
        int count = 0;

        while(true) {
            int num = count*(a+count) + b;
            if(!isPrime(num)) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int maxA = 0, maxB = 0, maxLength = 0;
        for(int a = -999; a < 1000; a++) {
            for(int b = -999; b <= 1000; b++) {
                int length = countPrimes(a, b);
                if(maxLength < length) {
                    maxA = a;
                    maxB = b;
                    maxLength = length;
                }
            }
        }
        System.out.println(maxA * maxB);
    }
}