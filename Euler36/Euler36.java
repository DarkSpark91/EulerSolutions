public class Euler36 {

    static int LIMIT = 1_000_000;

    static boolean isPalindrome(String test) {
        for(int i = 0; i < test.length()/2; i++) {
            if(test.charAt(i) != test.charAt(test.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    static boolean isPalindrome(int num) {
        return isPalindrome("" + num) && isPalindrome(Integer.toBinaryString(num));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0;

        for(int i = 0; i < LIMIT; i++) {
            if(isPalindrome(i)) {
                sum += i;
            }
        }

        System.out.println(sum);

        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}