import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester{
  public static void main(String[] args) {
    System.out.println("countTriangleA: "+countTrainglesA("inputTri.txt"));
    System.out.println("countTriangleB: "+countTrainglesB("inputTri.txt"));
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

  public static int countTrainglesB(String filename){
    int count=0;
    int[][] arr = new int[3][3];
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while(input.hasNextInt()){
        for (int i=0; i<3; i++) {
          arr[i]=lineToIntArray(input.nextLine());
        }
        count+=count3TrianglesB(arr);
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

  public static int[][] swapRC(int[][]nums){
    int[][] ans= new int[nums[0].length][nums.length];
    for (int i=0; i<nums[0].length; i++) {
      for (int j=0; j<nums.length; j++) {
          ans[i][j]=nums[j][i];
      }
    }
    return ans;
  }

  public static int count3TrianglesB(int[][] arr) {
    arr = swapRC(arr);
    int count=0;
    for (int i=0; i<3; i++) {
      if (isTriangle(arr[i])) {
        count++;
      }
    }
    return count;
  }
}
