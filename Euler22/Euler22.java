import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.util.Collections;

public class Euler22 {

    static long evalName(String s) {
        int sum = 0;
        //todo change to alphabet
        for(int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - 'A' + 1;
        }
        return sum;
    }

    static String[] getNames() {
        try(BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")))) {
            return br.readLine().split("\",\"");
        } catch(IOException ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        String[] names = getNames();
        names[0] = names[0].substring(1);
        names[names.length-1] = names[names.length-1].substring(0,names[names.length-1].length()-1);
        
        Arrays.sort(names);
        
        long sum = 0;
        for(int i = 0; i < names.length; i++) {
            
            sum += (i+1) * evalName(names[i]);
        }
        System.out.println(sum);
    }
}