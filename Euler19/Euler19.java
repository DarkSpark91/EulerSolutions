import java.util.Calendar;

public class Euler19 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int count = 0;
        for(int i = 1901; i <= 2000; i++) {
            for(int j = 0; j < 12; j++) {
                calendar.set(i, j, 1);
                if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}