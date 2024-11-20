import java.util.*;
import java.io.*;

public class Day12 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("2016d12.txt"));
            ArrayList<String[]> commands = new ArrayList<String[]>(1);
            while (sc.hasNextLine()) {
                commands.add(sc.nextLine().split(" "));
            }
            System.out.print("[");
            for (int i=0; i<commands.size(); i++) {
                System.out.print(Arrays.toString(commands.get(i)));
                if (i<commands.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
        
    }
}