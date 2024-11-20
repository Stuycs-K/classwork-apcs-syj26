import java.util.*;
import java.io.*;

public class Day10 {
    public static void main(String[] args) {
        ArrayList<String> going = new ArrayList<String>(1);
        ArrayList<String> giving = new ArrayList<String>(1);
        try {
            Scanner sc = new Scanner(new File("2016d10.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.charAt(0)=='b') {
                    giving.add(line);
                }
                if (line.charAt(0)=='v') {
                    going.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}