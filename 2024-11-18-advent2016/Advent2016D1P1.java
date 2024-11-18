import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Advent2016D1P1 {
  public static void main(String[] args) {
    int orientation = 1; //radians divided by pi/2 from positive x-axis
    //so 0 is right, 1 is up, 2 is left, 3 is down
    int dx=0;
    int dy=0;
    String step = "";
    Scanner sc = ReadFile.read("2016d1p1.txt");
    while (sc.hasNext()) {
      step = sc.next();
      step = step.substring(0, step.length()-1); //get rid of comma
      if step.substring(0, 1).equals("R") {
        orientation--;
      }
      if step.substring(0, 1).equals("R") {
        orientation++;
      }
      orientation%=4;
    }
  }

}
