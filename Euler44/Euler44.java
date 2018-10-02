public class Euler44 {

    public static int getPentagonal(int num) {
        return num * (3 * num - 1)/2;
    }

    public static boolean isPentagonal(int num) {
        double tmp = (1 + Math.sqrt(1 + 24 * num))/6;
        return tmp == Math.round(tmp);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int d = -1;

        boolean finished = true;

        for(int i = 1; finished; i++) {
            int pI = getPentagonal(i);
            for(int j = 1; j < i; j++) {
                int pJ = getPentagonal(j);
                d = pI - pJ;
                if(isPentagonal(d) && isPentagonal(pI + pJ)) {
                    finished = false;
                    break;
                }
            }
        }

        System.out.println(d);

        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}