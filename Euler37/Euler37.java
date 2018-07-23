public class Euler37 {

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

    public static boolean isTruncatablePrime(int num) {
        //todo fix this
        int tmp = num;
        int tmp2 = tmp;
        int count = 1;
        while(tmp > 0) {
            if(!isPrime[tmp] || !isPrime[tmp2]) {
                return false;
            }
            tmp /= 10;
            tmp2 = num % (10*count);
            count *= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        getPrimes(1_000_000);
        int count = 0;
        int sum = 0;
    
        for(int i = 10; count < 11; i++) {
            if(isTruncatablePrime(i)) {
                count++;
                sum += i;
            }
        }

        System.out.println(count);
        System.out.println(sum);

        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}