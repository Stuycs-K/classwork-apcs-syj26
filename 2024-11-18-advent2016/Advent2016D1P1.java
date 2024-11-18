import java.util.*;
import java.io.*;

public class Advent2016D1P1 {
  public static boolean contains(ArrayList<Point> visited, Point p) {
    for (int i=0; i<visited.size(); i++) {
      if (visited.get(i).equals(p)) {return true;}
    }
    return false;
  }

  public static void main(String[] args) {
    int orientation = 1; //radians divided by pi/2 from positive x-axis
    //so 0 is right, 1 is up, 2 is left, 3 is down
    Point position = new Point(0, 0);
    int change=0;
    String step = "";
    ArrayList<Point> visited = new ArrayList<Point>(10);
    boolean repeated = false;
    visited.add(new Point(position));
    try {
      File file = new File("2016d1p1.txt");
      Scanner sc = new Scanner(file);
      while (sc.hasNext()) {
        step = sc.next();
        if (step.substring(step.length()-1).equals(",")) {
          step = step.substring(0, step.length()-1); //get rid of comma
        }
        if (step.substring(0, 1).equals("R")) {
          orientation--;
        }
        if (step.substring(0, 1).equals("L")) {
          orientation++;
        }
        if (orientation<0) {orientation+=4;}
        if (orientation>3) {orientation-=4;}
        change = Integer.parseInt(step.substring(1));
        if (orientation==0) {
          for (int i=0; i<change; i++) {
            position.right(1);
            if (!repeated) {
            if (contains(visited, position)) {
              System.out.println(position);
              int dist=Math.abs(position.getX())+Math.abs(position.getY());
              System.out.println("manhattan distance: "+dist);
              repeated=true;
            }
          } 
          visited.add(new Point(position));
          }
        }
        if (orientation==1) {
          for (int i=0; i<change; i++) {
            position.up(1);
            if (!repeated) {
              if (contains(visited, position)) {
                System.out.println(position);
                int dist=Math.abs(position.getX())+Math.abs(position.getY());
                System.out.println("manhattan distance: "+dist);
                repeated=true;
              }
            } 
            visited.add(new Point(position));
            }
        }
        if (orientation==2) {
          for (int i=0; i<change; i++) {
            position.left(1);
            if (!repeated) {
              if (contains(visited, position)) {
                System.out.println(position);
                int dist=Math.abs(position.getX())+Math.abs(position.getY());
                System.out.println("manhattan distance: "+dist);
                repeated=true;
              }
            } 
            visited.add(new Point(position));
            }
        }
        if (orientation==3) {
          for (int i=0; i<change; i++) {
            position.down(1);
            if (!repeated) {
              if (contains(visited, position)) {
                System.out.println(position);
                int dist=Math.abs(position.getX())+Math.abs(position.getY());
                System.out.println("manhattan distance: "+dist);
                repeated=true;
              }
            } 
            visited.add(new Point(position));
            }
        }
      }
      sc.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    System.out.println(position);
    int dist=Math.abs(position.getX())+Math.abs(position.getY());
    System.out.println("manhattan distance: "+dist);
  }

}
