import java.util.*;
import java.io.*;

public class Driver {
  public static int[] randomArray(int len) {
    int[] arr=new int[len];
    for (int i=0; i<arr.length; i++) {
      arr[i]=(int) (100*Math.random());
    }
    return arr;
  }

  public static void color(int n) {
    if (n<25) {
      Text.color(Text.RED, Text.BRIGHT);
    }
    if (n>75) {
      Text.color(Text.GREEN, Text.BRIGHT);
    }
  }

  public static void drawHorizontalLine(int y, int length, String s) {
    for (int i=0; i<length; i++) {
      Text.go(y, i+1);
      Text.color(i%8+30, Text.background((i+4)%8+30));
      System.out.print(s);
    }
  }

  public static void drawVerticalLine(int x, int length, String s) {
    for (int i=0; i<length; i++) {
      Text.go(i+1, x);
      Text.color(i%8+30, Text.background((i+4)%8+30));
      System.out.print(s);
    }
  }

  public static void main(String[] args) {
    drawVerticalLine(1, 30, "!");
    drawVerticalLine(80, 30, "!");
    drawHorizontalLine(1, 80, "!");
    drawHorizontalLine(30, 80, "!");
    System.out.print(Text.RESET);
    int[] arr=randomArray(3);
    for (int i=0; i<3; i++) {
      Text.go(2, 20*(i+1));
      color(arr[i]);
      System.out.print(arr[i]+Text.RESET);
    }
    drawHorizontalLine(3, 80, "~");
    System.out.println(Text.RESET);
    Text.go(31, 1);
  }
}
