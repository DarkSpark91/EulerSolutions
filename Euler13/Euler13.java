import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.math.BigInteger;

public class Euler13 {

    static String getNum() {
        StringBuilder result = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")))) {
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                result.append(currentLine).append("\n");
            }
        } catch(IOException ex) {}
        return result.toString();
    }

    public static void main(String[] args) {
        String[] nums = getNum().split("\n");
        BigInteger sum = BigInteger.ZERO;
        
        for(String num : nums) {
            sum = sum.add(new BigInteger(num));
        }
        System.out.println(sum.toString().substring(0,10));
    } 
}