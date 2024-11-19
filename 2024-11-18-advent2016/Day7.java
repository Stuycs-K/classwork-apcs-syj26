import java.util.*;
import java.io.*;

public class Day7 {
  public static boolean isABBA(String s) {
    return (s.length()==4 && s.charAt(0)==s.charAt(3) && s.charAt(1)==s.charAt(2) && s.charAt(0)!=s.charAt(1));
  }
  public static void main(String[] args) {
    System.out.println(isABBA("aaaa"));
    System.out.println(isABBA("xoox"));
    System.out.println(isABBA("apcs"));
    try {
      Scanner sc = new Scanner(new File("2016d7.txt"));
      String line;
      while (sc.hasNextLine()) {
        line=sc.nextLine();
        //System.out.println(line);
      }
    } catch (Exception e) {
      System.out.println("File not found");
    }
  }
}
