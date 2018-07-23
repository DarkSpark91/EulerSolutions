public class Euler28 {
    public static void main(String[] args) {
        long sideLength = 1001;
        long num = 1;
        long sum = 1;
        
        for(long i = 3; i <= sideLength; i += 2) {
            for(long corner = 1; corner <= 4; corner++) {
                sum += num + (i-1)*corner;
            }
            num = num + (i-1)*4;
        }
        System.out.println(sum);
    }
}