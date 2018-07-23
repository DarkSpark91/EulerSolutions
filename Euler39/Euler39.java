import java.util.Arrays;

public class Euler39 {

    public static int getSolutions(int p) {
        int count = 0;
        for(int a = 0; a < p/(Math.sqrt(2) + 2); a++) {
            if(p*(p-2*a) % (2*(p - a)) == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int max = 0;
        int index = 0;

        for(int i = 10; i < 1000; i++) {
            int tmp = getSolutions(i);
            if(max < tmp) {
                max = tmp;
                index = i;
            }
        }

        System.out.println(index);
        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}