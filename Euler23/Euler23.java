import java.util.ArrayList;
import java.util.HashMap;

//todo fix
public class Euler23 {
    public static boolean isAbundant(long num) {
        int total = 1;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                total += i + num/i;
            }
        }
        return num < total;
    }

    public static boolean isSum(int num, int sub) {
        return isAbundant(num-sub);
    }

    public static boolean isNotSumable(int num, ArrayList<Integer> abundants) {
        for(Integer abun : abundants) {
            if(abun > num) {
                return true;
            } else if(isSum(num, abun)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int limit = 28123;
        ArrayList<Integer> abundants = new ArrayList<>();
        for(int n = 12; n < limit; n++) {
            if(isAbundant(n))
                abundants.add(n);
        }
        long sum = 0;
        for(int i = 0; i <= limit; i++) {
            if(isNotSumable(i, abundants)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}