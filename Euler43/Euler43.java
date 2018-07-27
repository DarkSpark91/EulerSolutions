import java.util.ArrayList;

public class Euler43 {

    static ArrayList<Long> getPandigitals() {
        ArrayList<Long> result = new ArrayList<Long>();
        ArrayList<Long> nums = new ArrayList<Long>();
        for(Long i = 0l; i <= 9; i++) {
            nums.add(i);
        }
        for(Long i = 1l; i <= 9; i++) {
            ArrayList<Long> tmpNums = (ArrayList<Long>)nums.clone();
            tmpNums.remove(i);
            getPandigitalTerms(i, tmpNums, result);
        }
        return result;
    }

    static void getPandigitalTerms(long num, ArrayList<Long> remainingNumbers, ArrayList<Long> result) {
        if(remainingNumbers.size() == 0) {
            result.add(num);
            return;
        }
        for(Long var : remainingNumbers) {
            ArrayList<Long> tmpNums = (ArrayList<Long>)remainingNumbers.clone();
            tmpNums.remove(var);
            long tmp = num*10 + var;
            getPandigitalTerms(tmp, tmpNums, result);
        }
    }
    
    static boolean subDivisbilible(Long num) {
        int[] primes = {17, 13, 11, 7, 5, 3, 2};
        for(int i = 0; i < primes.length; i++) {
            if((num % 1000) % primes[i] != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long total = 0l;
        
        for(Long i : getPandigitals()) {
            if(subDivisbilible(i)) {
                total += i;
            }
        }

        System.out.println(total);

        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}