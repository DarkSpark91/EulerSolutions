public class Euler2 {
    public static void main(String[] args) {
        long current = 1L;
        long last = 0L;
        long sum = 0;

        while(current <= 4000000) {
            if(current % 2 == 0) {
                sum += current;
            }
            long tmp = current;
            current += last;
            last = tmp;
        }
        System.out.println(sum);
       
    }
}