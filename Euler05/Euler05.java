public class Euler05 {

    static int[] nums = {20,19,18,17,16,15,14,13,12,11};

    static boolean isDivisible(int div) {
        for(Integer num : nums) {
            if(div % num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for(int i = 20; ; i += 20) {
            if(isDivisible(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}