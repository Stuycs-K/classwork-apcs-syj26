import java.util.*;
import java.io.*;

public class Day12 {
    public static int foo(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception ex) {
            return s.charAt(0)-'a';
        }
    }
    public static void copy(int[] abcd, String x, int y) {
        try {
            abcd[y]=Integer.parseInt(x);
        } catch (Exception ex) {
            abcd[y]=abcd[foo(x)];
        }
    }

    public static void main(String[] args) {
        int[] abcd=new int[4];
        //make c be 1
        abcd[2]=1;
        try {
            Scanner sc = new Scanner(new File("2016d12.txt"));
            ArrayList<String[]> commands = new ArrayList<String[]>(1);
            while (sc.hasNextLine()) {
                commands.add(sc.nextLine().split(" "));
            }
            //prints array
            System.out.print("[");
            for (int i=0; i<commands.size(); i++) {
                System.out.print(Arrays.toString(commands.get(i)));
                if (i<commands.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            //actual code
            boolean done=false;
            int i=0;
            while (!done) {
                try {
                    if (commands.get(i)[0].equals("jnz") && abcd[foo(commands.get(i)[1])]!=0) {
                        i+=Integer.parseInt(commands.get(i)[2]);
                    } else {
                        if (commands.get(i)[0].equals("cpy")) {
                            copy(abcd, commands.get(i)[1], foo(commands.get(i)[2]));
                        }
                        if (commands.get(i)[0].equals("inc")) {
                            abcd[foo(commands.get(i)[1])]++;
                        }
                        if (commands.get(i)[0].equals("dec")) {
                            abcd[foo(commands.get(i)[1])]--;
                        }
                        i++;
                    }
                } catch (IndexOutOfBoundsException ex) {
                    done=true;
                }
            }
            System.out.println(Arrays.toString(abcd));
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
        
    }
}