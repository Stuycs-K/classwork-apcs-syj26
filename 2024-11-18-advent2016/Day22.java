import java.util.*;
import java.io.*;

public class Day22 {
    public static void main(String[] args) {
        int[][][] data=new int[37][28][4];
        try {
            Scanner sc = new Scanner(new File("2016d22.txt"));
            while (sc.hasNextLine()) {
                Scanner line = new Scanner(sc.nextLine()); 
                String filesystem=line.next();
                String[] nums = new String[4];
                for (int i=0; i<4; i++) {
                    nums[i]=line.next();
                }
                int x = Integer.parseInt(filesystem.substring(filesystem.indexOf("x")+1, filesystem.indexOf("y")-1));
                int y = Integer.parseInt(filesystem.substring(filesystem.indexOf("y")+1));
                for (int i=0; i<4; i++) {
                    data[x][y][i]=Integer.parseInt(nums[i].substring(0, nums[i].length()-1));
                }
            }
            int count=0;
            for (int x=0; x<data.length; x++) {
                for (int y=0; y<data[x].length; y++) {
                    if (data[x][y][1] != 0) {
                        for (int i=0; i<data.length; i++) {
                            for (int j=0; j<data[x].length; j++) {
                                if ((i!=x || j!=y) && data[x][y][1]<=data[i][j][2]) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
        
    }
}