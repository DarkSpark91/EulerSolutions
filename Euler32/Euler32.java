import java.util.HashMap;
import java.util.HashSet;

public class Euler32 {

    public static boolean isPandigital(long num) {
        boolean[] digits = new boolean[9];
        while(num > 0) {
            int index = (int)(num % 10 - 1);
            if(index == -1 || digits[index]) {
                return false;
            } else {
                digits[index] = true;
            }
            num /= 10;
        }
        return true;
    }
       
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        HashSet<Long> set = new HashSet<Long>();
        for(long a = 0; a < 10000; a++) {
            for(long b = 0; b < 10000; b++) {
                String tmp = a + "" + b + "" + a*b;
                if(tmp.length() == 9 && isPandigital(Long.parseLong(tmp))) {
                    set.add(a*b);
                }
            }
        }
        long total = 0;

        for(Long num : set) {
            total += num;
        }

        System.out.println(total);
        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}