public class Euler40 {

    public static String getD(int term) {
        int total = 0;
        StringBuilder num = new StringBuilder();
        for(int i = 0; i < term; i++) {
            num.append(i);
        }

        return num.toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String num = getD(400000);
        int product = 1;

        for(int i = 1; i <= 1000000; i *= 10) {
            product *= Character.getNumericValue(num.charAt(i));
        }

        System.out.println(product);

        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}