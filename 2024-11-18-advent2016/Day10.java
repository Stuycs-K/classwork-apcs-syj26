import java.util.*;
import java.io.*;

public class Day10 {
    public static void main(String[] args) {
        ArrayList<String> going = new ArrayList<String>(1);
        ArrayList<String> giving = new ArrayList<String>(1);
        int[][] bots = new int[300][2];
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
            for (int i=0; i<going.size(); i++) {
                String line=going.get(i);
                int value, bot;
                line=line.substring(line.indexOf(" ")+1);
                value=Integer.parseInt(line.substring(0, line.indexOf(" ")));
                bot=Integer.parseInt(line.substring(line.indexOf("bot")+4));
                if (bots[bot][0]==0) {
                    bots[bot][0]=value;
                } else {
                    bots[bot][1]=value;
                }
            }
            System.out.println(Arrays.deepToString(bots));
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}