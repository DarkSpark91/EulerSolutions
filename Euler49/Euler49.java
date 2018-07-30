import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Euler49 {

    static ArrayList<Integer> getPrimes(int n) {        
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            primes.add(i);
        }
        for (int factor = 2; factor*factor <= n; factor++) {
            if (primes.get(factor - 2) != 0) {
                for (int j = factor; factor*j <= n; j++) {
                    primes.set((factor*j) - 2, 0);
                }
            }
        }
        primes.removeIf(p -> (p == 0 || p < 1000));
        return primes;
    }

    public static boolean isPermutation(int i, int j, int k) {
        if(i == j || k == j)
            return false;
        Perm iPerm = new Perm(i);
        Perm jPerm = new Perm(j);
        Perm kPerm = new Perm(k);
        return iPerm.equals(jPerm) && jPerm.equals(kPerm);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList<Integer> primes = getPrimes(10000);

        for(int i = 0; i < primes.size(); i++) {
            for(int j = i+1; j < primes.size(); j++) {
                int d = primes.get(j) - primes.get(i);
                int k = d + primes.get(j);
                if(k < 10000 && primes.contains(k)) {
                    if(isPermutation(primes.get(i), primes.get(j), k)) {
                        System.out.println("" + primes.get(i) + primes.get(j) + k);
                    }
                }
            }
        }

        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}

class Perm extends ArrayList {
    
    Perm(int num) {
        while(num > 0) {
            add(num % 10);
            num /= 10;
        }
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Perm)) {
            return false;
        }
        Perm other = (Perm)o;
        Collections.sort(this);
        Collections.sort(other);
        return size() == other.size() && super.equals(other);
    }
}