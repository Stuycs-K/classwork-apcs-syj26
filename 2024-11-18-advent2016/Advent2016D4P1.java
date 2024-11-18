import java.util.*;
import java.io.*;

public class Advent2016D4P1 {
    //return sectorID
    public static int sectorID(String line) {
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

    //cuts away the sectorID and checksum
    public static String cut(String line) {
        int end=0;
        int i=0;
        while (end==0) {
            if (line.charAt(i)<='9' && line.charAt(i)>='0') {
                end=i;
            }
            i++;
        }
        return line.substring(0, end-1);
    }
    
    public static int[][] frequencies(String line) {
        int[][] ans = new int[26][2];
        for (int i=0; i<26; i++) {
            ans[i][0]=i; //represents the letter
        }
        line=cut(line);
        for (int i=0; i<line.length(); i++) {
            if (line.charAt(i)<='z' && line.charAt(i)>='a') {
                ans[line.charAt(i)-'a'][1]+=1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        try {
            File file = new File("2016d4.txt");
            Scanner sc = new Scanner(file);
            String line;
            while (sc.hasNextLine()) {
                line=sc.nextLine();
                System.out.println(cut(line));
                System.out.println(sectorID(line));
                System.out.println(Arrays.deepToString(frequencies(line)));
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
    
}