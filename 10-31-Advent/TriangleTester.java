import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester{
  public static void main(String[] args) {
    System.out.println(countTrainglesA("inputTri.txt"));
  }
 
  public static int countTrainglesA(String filename){
    int count=0;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while(input.hasNextLine()){
        if(isTriangle(input.nextLine())) {
            count++;
        }
      }
      input.close();
      return count;
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      return -1;
    }
  }

  public static boolean isTriangle(String input){
    Scanner sc = new Scanner(input);
    int s0 = sc.nextInt(); int s1 = sc.nextInt(); int s2 = sc.nextInt();
    return (s0 + s1 > s2 && s1 + s2 > s0 && s2 + s0 > s1);
  }
}