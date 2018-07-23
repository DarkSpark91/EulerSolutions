import java.util.ArrayList;
import java.util.Arrays;

public class Euler24 {

    public static int getFactorial(int num) {
        if(num == 0) {
            return 1;
        }
        return num * getFactorial(num-1);
    }

    public static String getTerm(ArrayList<Integer> list, int term) {
        if(list.size() == 1) {
            return "" + list.get(0);
        }
        int fac = getFactorial(list.size()-1);
        int index = term / fac;
        int nextTerm = term % fac;
        return "" + list.remove(index) + getTerm(list, nextTerm);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int a = 0; a < 10; a++) {
            list.add(a);
        }
        System.out.println(getTerm(list, 1_000_000-1));
    }
}