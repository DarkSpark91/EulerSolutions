public class Euler21 {

    static long d(long num) {
        long total = 1;
        for(long i = 2; i*i <= num; i++) {
            if(num % i == 0) {
                total += i + num/i;
            }
        }
        return total;
    }

    static boolean isAmicable(long num) {
        return num != d(num) && num == d(d(num));
    }

    public static void main(String[] args) {
        long sum = 0;
        System.out.println(isAmicable(220));
        for(long i = 1; i < 10000; i++) {
            if(isAmicable(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}