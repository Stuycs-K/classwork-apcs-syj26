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
      while(input.hasNextInt()){
        if(isTriangle(lineToIntArray(input.nextLine()))) {
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

  public static int[] lineToIntArray(String input) {
    Scanner sc = new Scanner(input);
    int[] s=new int[3];
    for (int i=0; i<3; i++) {
      s[i] = sc.nextInt();
    }
    return s;
  }

  public static boolean isTriangle(int[] s){
    return (s[0] + s[1] > s[2] && s[1] + s[2] > s[0] && s[2] + s[0] > s[1]);
  }
}
