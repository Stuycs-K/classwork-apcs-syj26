import java.util.*;
import java.io.*;

public class Day21 {
    public static String swap(String str, int X, int Y) {
        if (X>Y) {return swap(str, Y, X);}
        return str.substring(0, X)+str.charAt(Y)+str.substring(X+1, Y)+str.charAt(X)+str.substring(Y+1);
    }
    public static String swap(String str, String X, String Y) {
        int Xpos=str.indexOf(X); int Ypos=str.indexOf(Y);
        if (Xpos>Ypos) {return swap(str, Y, X);}
        return str.substring(0, Xpos)+Y+str.substring(Xpos+1, Ypos)+X+str.substring(Ypos+1);
    }
    //right -> dir>0, left -> dir<0
    public static String rotate(String str, int dir) {
        return str.substring((str.length()-dir)%str.length())+str.substring(0, (str.length()-dir)%str.length());
    }
    public static String rotate(String str, String X) {
        int index=str.indexOf(X);
        str=rotate(str, index+1);
        if (index>=4) {return rotate(str, 1);}
        return str;
    }
    public static String reverse(String str) {
        String ans="";
        for (int i=str.length()-1; i>=0; i--) {
            ans+=str.charAt(i);
        }
        return ans;
    }
    public static String reverse(String str, int X, int Y) {
        if (X>Y) {return reverse(str, Y, X);}
        return str.substring(0, X)+reverse(str.substring(X, Y+1))+str.substring(Y+1);
    }
    public static String move(String str, int X, int Y) {
        String Xth=""+str.charAt(X);
        str=str.substring(0, X)+str.substring(X+1);
        return str.substring(0, Y)+Xth+str.substring(Y);
    }
    public static void main(String[] args) {
        String str="abcdefgh";
        try {
            Scanner sc=new Scanner(new File("2016d21.txt"));
            while (sc.hasNextLine()) {
                String command = sc.nextLine();
                if (command.substring(0, 13).equals("swap position")) {
                    int X=Integer.parseInt(command.substring(14, 15));
                    int Y=Integer.parseInt(command.substring(command.length()-1));
                    str=swap(str, X, Y);
                    System.out.println("swap position "+X+" with position "+Y);
                }
                if (command.substring(0, 11).equals("swap letter")) {
                    String X=command.substring(12, 13);
                    String Y=command.substring(command.length()-1);
                    str=swap(str, X, Y);
                    System.out.println("swap letter "+X+" with letter "+Y);
                }
                if (command.substring(0, 6).equals("rotate")) {
                    if (command.substring(7, 12).equals("right")) {
                        int dir=Integer.parseInt(command.substring(13, 14));
                        str=rotate(str, dir);
                        System.out.println("rotate right "+dir+" steps");
                    }
                    if (command.substring(7, 11).equals("left")) {
                        int dir=Integer.parseInt(command.substring(12, 13));
                        str=rotate(str, -1*dir);
                        System.out.println("rotate left "+dir+" steps");
                    }
                    if (command.substring(7, 12).equals("based")) {
                        String X=command.substring(command.length()-1);
                        str=rotate(str, X);
                        System.out.println("rotate based on position of letter "+X);
                    }
                }
                if (command.substring(0, 7).equals("reverse")) {
                    int X=Integer.parseInt(command.substring(18, 19));
                    int Y=Integer.parseInt(command.substring(command.length()-1));
                    str=reverse(str, X, Y);
                    System.out.println("reverse positions "+X+" through "+Y);
                }
                if (command.substring(0, 4).equals("move")) {
                    int X=Integer.parseInt(command.substring(14, 15));
                    int Y=Integer.parseInt(command.substring(command.length()-1));
                    str=move(str, X, Y);
                    System.out.println("move position "+X+" to position "+Y);
                }
            }
            System.out.println(str);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
        
    }
}