public class Euler45 {

    static boolean isPentagonal(long num) {
        double tmp = (1 + Math.sqrt(1 + 24 * num))/6;
        return tmp == Math.round(tmp);
    }

    static boolean isTriangleNum(long num) {
        double triNum = (Math.sqrt(1+8*num)-1)/2;
        return triNum == Math.round(triNum);
    }

    static long getHexagonal(long num) {
        return num * (2 * num - 1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long i = 144;
        long hex = 0;

        while(true) {
            hex = getHexagonal(i);
            if(isTriangleNum(hex) && isPentagonal(hex)) {
                break;
            }
            i++;
        }

        System.out.println(hex);

        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}