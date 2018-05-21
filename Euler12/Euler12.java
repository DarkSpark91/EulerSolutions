public class Euler12 {

    static long sum(double n) {
        return (long)(n/2*(2*(1)+(n-1)*1));
    }

    static long getnum(int div) {
        long count = 0;
        long num = 0;
        for(long i = 0; count < div; i++) {
            count = 0;
            num += i;
            for(int j = 1; j*j < num; j++) {
                if(num % j == 0) {
                    count += 2;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(getnum(500));
    }
}