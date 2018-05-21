import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.File;

public class Euler67 {
    static int[] getInt(String[] array) {
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
    
        return result;
    }

    static int[][] getTri() {
        int[][] result = new int[100][];
        try(BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")))) {
            String currentLine;
            int i = 0;
            while((currentLine = br.readLine()) != null) {
                result[i] = getInt(currentLine.split(" "));
                i++;
            }
        } catch (IOException ex) {}
        return result;
    }

    public static void main(String[] args) {
        int[][] tri = getTri();
        
        for(int i = tri.length-1; i >0; i--) {
            for(int j = 0; j < tri[i].length-1; j++) {
                tri[i-1][j] = Math.max(tri[i][j], tri[i][j+1]) + tri[i-1][j];
            }
        }
        System.out.println(tri[0][0]);
    }
}