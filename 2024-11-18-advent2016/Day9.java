import java.util.*;
import java.io.*;

public class Day9 {
    public static String uncompress(String input) {
        String uncompressed="";
        while (input.length()>0) {
            if (input.charAt(0)=='(') {
                int rightParenthesis = input.indexOf(")");
                int lookNext = Integer.parseInt(input.substring(1, rightParenthesis).split("x")[0]);
                int repeat = Integer.parseInt(input.substring(1, rightParenthesis).split("x")[1]);
                input=input.substring(rightParenthesis+1);
                uncompressed+=input.substring(0, lookNext).repeat(repeat);
                input=input.substring(lookNext);
            } else {
                uncompressed+=input.charAt(0);
                input=input.substring(1);
            }
        }
        return uncompressed;
    }
    public static void main(String[] args) {
        try {
            String input="ADVENT";
            System.out.println(uncompress(input).length());
            System.out.println(uncompress(input));
            input="A(1x5)BC";
            System.out.println(uncompress(input).length());
            System.out.println(uncompress(input));
            input="(3x3)XYZ";
            System.out.println(uncompress(input).length());
            System.out.println(uncompress(input));            
            input="A(2x2)BCD(2x2)EFG";
            System.out.println(uncompress(input).length());
            System.out.println(uncompress(input));
            input="(6x1)(1x3)A";
            System.out.println(uncompress(input).length());
            System.out.println(uncompress(input));            
            input="X(8x2)(3x3)ABCY";
            System.out.println(uncompress(input).length());
            System.out.println(uncompress(input));    
            input = (new Scanner(new File("2016d9.txt"))).next();
            System.out.println("Length of uncompressed input: "+uncompress(input).length());    
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}