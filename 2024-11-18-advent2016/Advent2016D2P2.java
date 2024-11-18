import java.util.*;
import java.io.*;

public class Advent2016D2P2 {
    public static int absSum(Point p) {
        return Math.abs(p.getX())+Math.abs(p.getY());
    }
    public static void main(String[] args) {
        Point position = new Point(0, 0);
        try {
            File file = new File("2016d2.txt");
            Scanner sc = new Scanner(file);
            String move;
            String[] moves;
            int mdist;
            while (sc.hasNextLine()) {
                move = sc.nextLine();
                moves = move.split("");
                for (int i=0; i<moves.length; i++) {
                    mdist=absSum(position);
                    if (moves[i].equals("L")) {
                        if (mdist<2 || position.getX()>0) {
                            position.left(1);
                        }
                    }
                    if (moves[i].equals("R")) {
                        if (mdist<2 || position.getX()<0) {
                            position.right(1);
                        }
                    }
                    if (moves[i].equals("D")) {
                        if (mdist<2 || position.getY()>0) {
                            position.down(1);
                        }
                    }
                    if (moves[i].equals("U")) {
                        if (mdist<2 || position.getY()<0) {
                            position.up(1);
                        }
                    }
                }
                System.out.println(position);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
}