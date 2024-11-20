import java.util.*;
import java.io.*;

public class Day9P2 {
    public static long uncompress(String input) {
        long len=0;
        while (input.length()>0) {
            if (input.charAt(0)=='(') {
                int rightParenthesis = input.indexOf(")");
                int lookNext = Integer.parseInt(input.substring(1, rightParenthesis).split("x")[0]);
                int repeat = Integer.parseInt(input.substring(1, rightParenthesis).split("x")[1]);
                input=input.substring(rightParenthesis+1);
                len+=uncompress(input.substring(0, lookNext))*repeat;
                input=input.substring(lookNext);
            } else {
                input=input.substring(1);
                len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        try {
            String input="ADVENT";
            System.out.println(uncompress(input));
            input="(3x3)XYZ";
            System.out.println(uncompress(input));            
            input="X(8x2)(3x3)ABCY";
            System.out.println(uncompress(input));
            input="(27x12)(20x12)(13x14)(7x10)(1x12)A";
            System.out.println(uncompress(input));            
            input="(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN";
            System.out.println(uncompress(input));    
            input = (new Scanner(new File("2016d9.txt"))).next();
            System.out.println("Length of uncompressed input: "+uncompress(input));    
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}