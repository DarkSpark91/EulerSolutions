import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Euler42 {

    static HashMap<Character, Integer> getAlpha() {
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < alphabet.length(); i++) {
            result.put(alphabet.charAt(i), i+1);
        }

        return result;
    }

    static ArrayList<String> getWords() {
        StringBuilder builder = new StringBuilder();
        BufferedReader in = null;
        try{
            in = new BufferedReader(new FileReader(new File("input.txt")));

            String currentLine;
            while((currentLine = in.readLine()) != null) {
                builder.append(currentLine);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(builder.toString());
        ArrayList<String> result = new ArrayList<String>();
        while(matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
    }

    static boolean isTriangleNum(int num) {
        double triNum = (Math.sqrt(1+8*num)-1)/2;
        return triNum == Math.round(triNum);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = 0;
        HashMap<Character, Integer> alpha = getAlpha();
        for(String var : getWords()) {
            int tmp = 0;
            for(int i = 0; i < var.length(); i++) {
                tmp += alpha.get(var.charAt(i));
            }
            if(isTriangleNum(tmp)) {
                count++;
            }
        }

        System.out.println(count);
        System.out.println("Program took " 
            + (System.currentTimeMillis() - start) + "ms");
    }
}