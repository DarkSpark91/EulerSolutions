public class Euler34 {


    public static int factorial(int num) {
        if(num == 0) return 1;
        return num * factorial(num-1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = new int[10];
        int sum = 0;
        int limit = factorial(9)*7;
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = factorial(i);
        }
        
        for(int i = 3; i <= limit; i++) {
            int tmpSum = 0;
            int n = i;
            while(n > 0) {
                tmpSum += nums[(int)n%10];
                n /= 10;
            }
            if(tmpSum == i) {
                sum += i;
            } 
        }

        System.out.println(sum);

        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}