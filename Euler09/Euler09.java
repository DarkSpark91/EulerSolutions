public class Euler09 {

    static boolean isTriplet(long a, long b, long c) {
        return a*a + b*b == c*c;
    }

    public static void main(String[] args) {
        for(long a = 1; a < 1000; a++) {
            for(long b = a+1; b < 1000; b++) {
                long c = 1000-a-b;
                if(isTriplet(a, b, c)) {
                    System.out.println(a * b * c);
                }
            }
        }
    }
}