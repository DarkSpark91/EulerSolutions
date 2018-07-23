public class Euler26 {
    public static void main(String[] args) {
        int maxLength =0, maxNum = 0, remainder = 0, length = 0;
        for(int d = 999; d > 2; d -= 2) {
            if(d % 5 == 0)
                continue;

            int num = 1;
            remainder = num%d;
            num = remainder * 10;
            for(length = 0; length <= d; length++) {
                if(num >= d) {
                    num %= d;
                }
                if(num == remainder) 
                    break;
                num *= 10;
            }
            if(length+2 == d) {
                System.out.println(d);
                break;
            }
        }
    }
}