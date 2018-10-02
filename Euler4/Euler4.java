import java.util.ArrayList;

public class Euler4 {
    static int upper = 1000000;
    static int lower = 100000;

    static boolean isPalindrome(int num) {
        ArrayList<Integer> numList = new ArrayList<>();
        for(Integer i = num; i > 1; i /= 10) {
            numList.add(i % 10);
        }
        for(int i = 0; i < numList.size()/2; i++) {
            if (numList.get(i) != numList.get(numList.size() - i -1)) {
                return false;
            }
        }
        return true;
    }

    static ArrayList<Integer> getPalindromes() {
        ArrayList<Integer> result = new ArrayList<>();
        for(Integer i = 100001; i < upper; i++) {
            if(isPalindrome(i)) {
                result.add(i);
            }
        }
        return result;
    }

    static boolean isProduct(double num) {
        for(double i = 100; i < 1000; i++) {
            double tmp = num / i;
            if(tmp % 1 == 0 && tmp > 100.0 && tmp < 1000.0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = getPalindromes();
        for(int i = array.size() - 1; i > 0; i--) {
            if(isProduct((double)array.get(i))) {
                System.out.println(array.get(i));
                break;
            }
        }
    }
}