import java.util.*;
import java.io.*;

public class Day8 {
    public static void rect(boolean[][] screen, int A, int B) {
        for (int i=0; i<A; i++) {
            for(int j=0; j<B; j++) {
                screen[j][i]=true;
            }
        }
    }
    public static void row(boolean[][] screen, int y, int B) {
        boolean temp;
        for (int times=0; times<(B % screen[0].length); times++) {
            temp=screen[y][screen[0].length-1];
            for (int i=screen[0].length-1; i>0; i--) {
                screen[y][i]=screen[y][i-1];
            }
            screen[y][0]=temp;
        }
    }
    public static void col(boolean[][] screen, int x, int B) {
        boolean temp;
        for (int times=0; times<(B %screen.length); times++) {
            temp=screen[screen.length-1][x];
            for (int i=screen.length-1; i>0; i--) {
                screen[i][x]=screen[i-1][x];
            }
            screen[0][x]=temp;
        }
    }
    public static void main(String[] args) {
        boolean[][] screen = new boolean[3][7];
        rect(screen, 3, 2);
        col(screen, 1, 1);
        row(screen, 0, 4);
        col(screen, 1, 1);
        System.out.println(Arrays.deepToString(screen));
        try {
            Scanner sc=new Scanner(new File("2016d8.txt"));
        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}