import java.util.*;
import java.io.*;

public class Advent2016D4P1 {
    public static int checksum(String line) {
        int ans=0;
        int left=0; int right=0; int i=line.length()-1; boolean done=false;
        while (i>=0 && !done) {
            if (line.charAt(i)<='9' && line.charAt(i)>='0') {
                right=i+1;
                done=true;
            }
            i--;
        }
        done=false;
        while (i>=0 && !done) {
            if (line.charAt(i)>'9' || line.charAt(i)<'0') {
                left=i+1;
                done=true;
            }
            i--;
        }
        return Integer.parseInt(line.substring(left, right));
    }
    public static void main(String[] args) {
        try {
            File file = new File("2016d4.txt");
            Scanner sc = new Scanner(file);
            String line;
            while (sc.hasNextLine()) {
                line=sc.nextLine();
                System.out.println(checksum(line));
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
    
}