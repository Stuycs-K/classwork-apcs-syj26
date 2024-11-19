import java.util.*;
import java.io.*;

public class Day7P2 {
  public static boolean isABA(String s) {
    return (s.length()==3 && s.charAt(0)==s.charAt(2) && s.charAt(0)!=s.charAt(1));
  }
  public static boolean hasABA(String s) {
    for (int i=0; i<s.length()-2; i++) {
      if (isABA(s.substring(i, i+3))) {
        return true;
      }
    }
    return false;
  }
  public static String reverseABA(String aba) {
    return ""+aba.charAt(1)+aba.charAt(0)+aba.charAt(1);
  }
  public static ArrayList<String> findABA(String s) {
    ArrayList<String> arr = new ArrayList<String>(1);
    for (int i=0; i<s.length()-2; i++) {
        if (isABA(s.substring(i, i+3))) {
          arr.add(s.substring(i, i+3));
        }
    }
    return arr;
  }
  /* 
  public static boolean bracketABBA(String s) {
    boolean inBracket=false; int start=0, end=0;
    for (int i=0; i<s.length(); i++) {
      if (!inBracket) {
        inBracket=(s.charAt(i)=='[');
        start=i+1;
      } else {//if inBracket
        if (s.charAt(i)==']') {
          end=i;
          inBracket=false;
          if (hasABBA(s.substring(start, end))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  public static boolean textABBA(String s) {
    boolean inBracket=false; int start=0, end=0;
    for (int i=0; i<s.length(); i++) {
      if (!inBracket && s.charAt(i)=='[') {
        inBracket=true;
        end=i;
        if (hasABBA(s.substring(start, end))) {
          return true;
        }
      } else {//if inBracket
        if (s.charAt(i)==']') {
          start=i+1;
          inBracket=false;
        }
      }
    }
    if (hasABBA(s.substring(start))) {return true;}
    return false;
  }
    */
  public static void main(String[] args) {
    System.out.println(reverseABA("aba"));
    try {
      Scanner sc = new Scanner(new File("2016d7.txt"));
      String line; int count=0;
      while (sc.hasNextLine()) {
        line=sc.nextLine();
      }
      System.out.println(count);
    } catch (Exception e) {
      System.out.println("File not found");
    }
  }
}
