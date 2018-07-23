public class Euler33 {

    public static boolean isTrivial(int num, int dom) {
        return (num % 10 == 0 && dom % 10 == 0);
    }

    public static int getLowDom(int num, int dom) {
        return dom/num;
    }

    public static boolean simplify(int num, int dom) {
        double value = (double)num/dom;
        double num1 = (double)(num/10);
        double num2 = (double)(num%10);
        double dom1 = (double)(dom/10);
        double dom2 = (double)(dom%10);

        return !isTrivial(num, dom) 
            && ((num1 == dom1 && num2/dom2 == value)
            || (num2 == dom2 && num1/dom1 == value)
            || (num1 == dom2 && num2/dom1 == value)
            || (num2 == dom1 && num1/dom2 == value));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int totalNum = 1;
        int totalDom = 1;
        for(int num = 10; num < 100; num++) {
            for(int dom = 10; dom < 100; dom++) {
                if(num/dom < 1 && simplify(num, dom)) {
                    totalNum *= num;
                    totalDom *= dom;
                }
            }
        }
        System.out.println(getLowDom(totalNum, totalDom));
        
        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}