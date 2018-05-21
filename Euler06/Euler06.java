import java.util.ArrayList;

public class Euler06 {

    static long getDifference(ArrayList<Integer> nums) {
        long sum1 = nums.stream().mapToInt(Integer::intValue).sum();
        sum1 = sum1 * sum1;
        long sum2 = 0;
        for(Integer num : nums) {
            sum2 += num*num;
        }
        return sum1 - sum2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            ints.add(i);
        }
        System.out.println(getDifference(ints));
    }
}