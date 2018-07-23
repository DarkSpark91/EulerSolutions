import java.util.Arrays;
import java.util.HashSet;

public class Euler38 {

    public static boolean isPandigital(String num) {
        HashSet<Character> set = new HashSet<Character>();
        for(char a : num.toCharArray()) {
            set.add(a);
        }
        return set.size() == 9 && !set.contains('0');
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i = 9487; i > 9213; i--) {
            String num = "" + i + "" + i*2;
            if(isPandigital(num)) {
                System.out.println(num);
                break;
            }
        }
        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}