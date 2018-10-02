public class Euler3 {	
	

	static boolean isPrime(long num) {
        if (num == 2 || num == 3) {
            return true;
        } else if(num % 2 == 0 || num % 3 ==0) {
            return false;
        }
        for(long i = 6L; i <= Math.sqrt(num); i += 6L) {
            if(num % (i+1) == 0 || num % (i-1) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long num = 600851475143L;
        long limit = (long)Math.sqrt(num);

        for(long i = limit; i >= 1; i--) {
            if(num % i == 0) {
                if(isPrime(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}