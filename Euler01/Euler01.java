public class Euler01 {
    public static void main(String[] args) {
        long total = 0;
        for(int i = 0; i < 1000; i++) {
            if(i % 5 == 0 || i % 3 == 0)
                total += i;
        }
        System.out.println(total);
    }
}