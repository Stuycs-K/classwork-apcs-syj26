import java.util.*;
import java.io.*;

public class Day7 {
  public static void main(String[] args) {
    try {
      Scanner sc = new Scanner(new File("2016d7.txt"));
      String line;
      while (sc.hasNextLine()) {
        line=sc.nextLine();
        System.out.println(line);
      }
    } catch (Exception e) {
      System.out.println("File not found");
    }
  }
}
