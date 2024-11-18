import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Advent2016D1P1 {
  public static void main(String[] args) {
    int orientation = 1; //radians divided by pi/2 from positive x-axis
    //so 0 is right, 1 is up, 2 is left, 3 is down
    int dx=0;
    int dy=0;
    int change=0;
    String step = "";
    try {
      File file = new File("2016d1p1.txt");
      Scanner sc = new Scanner(file);
      sc.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    while (sc.hasNext()) {
      step = sc.next();
      step = step.substring(0, step.length()-1); //get rid of comma
      if (step.substring(0, 1).equals("R")) {
        orientation--;
      }
      if (step.substring(0, 1).equals("R")) {
        orientation++;
      }
      orientation%=4;
      change = Integer.parseInt(step.substring(1));
      if (orientation==0) {
        dx+=change;
      }
      if (orientation==1) {
        dy+=change;
      }
      if (orientation==2) {
        dx-=change;
      }
      if (orientation==3) {
        dy-=change;
      }
    }
    System.out.println(dx+" "+dy);
  }

}
