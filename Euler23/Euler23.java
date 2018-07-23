import java.util.ArrayList;
import java.util.HashMap;

public class Euler23 {
    private static boolean isAbundant(int n) {
		if (n < 1)
			throw new IllegalArgumentException(""+n);
		
		int sum = 1;
		int end = (int)Math.sqrt(n);
		for (int i = 2; i <= end; i++) {
			if (n % i == 0)
				sum += i + n / i;
		}
		if (end * end == n)
			sum -= end;
		return sum > n;
}

    public static boolean isSum(int num, int sub) {
        return num != sub && isAbundant(Math.abs(num-sub));
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
        long limit = 28123;
        ArrayList<Integer> abundants = new ArrayList<>();
        for(int n = 12; n < limit; n++) {
            if(isAbundant(n))
                abundants.add(n);
        }
        long sum = 0;
        for(int i = 1; i <= limit; i++) {
            if(isNotSumable(i, abundants)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}