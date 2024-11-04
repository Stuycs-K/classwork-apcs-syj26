import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile {
  public static boolean isTriangle(int[] s){
    return (s[0] + s[1] > s[2] && s[1] + s[2] > s[0] && s[2] + s[0] > s[1]);
  }

  public static void main(String[] args) {
    Scanner sc1 = new Scanner("This is a bunch of words");
    while (sc1.hasNext()) {
      System.out.println(sc1.next());
    }

    Scanner sc2=new Scanner("10.0 1.04 99.0 -3.0 4.2");
    double sum=0;
    while (sc2.hasNextDouble()) {
      sum+=sc2.nextDouble();
    }
    System.out.println(sum);

    try {
      File file = new File("ReadFile.java");
      Scanner input = new Scanner(file);
      /*
      int i=0;
      while (input.hasNextLine()) {
        if (i%2==0) {
          System.out.println(input.nextLine());
        }
        else {
          input.nextLine();
        }
        i++;
      }
      */
      String nextline;
      while (input.hasNextLine()) {
        nextline=input.nextLine();
        if (nextline.indexOf("{")>=0) {
          System.out.println(nextline);
        }
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found");
      return;
    }

    try {
      File file = new File("inputTri_x.txt");
      Scanner input = new Scanner(file);
      if (file.hasNextInt()) {
        String line=file.nextLine();
        String[] nums = line.split("x");
      }
    }
  }
}
