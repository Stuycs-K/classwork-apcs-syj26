import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Advent2016D2P1 {
    public static void main(String[] args) {
        Point position = new Point(0, 0);
        try {
            File file = new File("2016d2p1.txt");
            Scanner sc = new Scanner(file);
            String move;
            String[] moves;
            while (sc.hasNextLine()) {
                move = sc.nextLine();
                moves = move.split("");
                for (int i=0; i<moves.length; i++) {
                    if (moves[i].equals("L")) {
                        if (position.getX()>-1) {
                            position.left();
                        }
                    }
                    if (moves[i].equals("R")) {
                        if (position.getX()<1) {
                            position.right();
                        }
                    }
                    if (moves[i].equals("D")) {
                        if (position.getY()>-1) {
                            position.down();
                        }
                    }
                    if (moves[i].equals("U")) {
                        if (position.getY()<1) {
                            position.up();
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