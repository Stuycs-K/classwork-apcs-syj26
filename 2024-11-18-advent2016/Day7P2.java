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
  public static void findABA(String s, ArrayList<String> arr) {
    for (int i=0; i<s.length()-2; i++) {
        if (isABA(s.substring(i, i+3))) {
          arr.add(s.substring(i, i+3));
        }
    }
  }
  public static ArrayList<String> bracketABA(String s) {
    boolean inBracket=false; int start=0, end=0;
    ArrayList<String> ans = new ArrayList<String>(1);
    for (int i=0; i<s.length(); i++) {
      if (!inBracket) {
        inBracket=(s.charAt(i)=='[');
        start=i+1;
      } else {//if inBracket
        if (s.charAt(i)==']') {
            end=i;
            inBracket=false;
            findABA(s.substring(start, end), ans);
        }
      }
    }
    return ans;
  }
  public static ArrayList<String> textABA(String s) {
    boolean inBracket=false; int start=0, end=0;
    ArrayList<String> ans = new ArrayList<String>(1);
    for (int i=0; i<s.length(); i++) {
      if (!inBracket && s.charAt(i)=='[') {
        inBracket=true;
        end=i;
        findABA(s.substring(start, end), ans);
      } else {//if inBracket
        if (s.charAt(i)==']') {
          start=i+1;
          inBracket=false;
        }
      }
    }
    findABA(s.substring(start), ans);
    return ans;
  }
  public static boolean works(ArrayList<String> bracket, ArrayList<String> text) {
    String reversed;
    for (int i=0; i<bracket.size(); i++) {
        reversed=reverseABA(bracket.get(i));
        for (int j=0; j<text.size(); j++) {
            if (reversed.equals(text.get(j))) {
                return true;
            }
        }
    }
    return false;
  }
  public static void main(String[] args) {
    try {
      Scanner sc = new Scanner(new File("2016d7.txt"));
      String line; int count=0; 
      while (sc.hasNextLine()) {
        line=sc.nextLine();
        if (works(bracketABA(line), textABA(line))) {
            count++;
        }
      }
      System.out.println(count);
    } catch (Exception e) {
      System.out.println("File not found");
    }
  }
}
