public class Euler14{
    public static void main(String[] args) {
        int maxChain = 0;
        int maxIndex = 0;

        for(int i = 1; i < 1000000; i++) {
            long num = i;
            int count = 0;
            while(num != 1) {
                count++;
                if(count > maxChain) {
                    maxChain = count;
                    maxIndex = i;
                }
                if(num % 2 == 0) {
                    num = num/2;
                } else {
                    num = 3*num + 1;
                }
            }
        }

        System.out.println(maxIndex);
    }
}