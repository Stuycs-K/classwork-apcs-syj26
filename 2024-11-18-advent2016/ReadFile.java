import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile {
  public static Scanner read(String filename) {
    Scanner input = new Scanner("");
    try {
      File file = new File(filename);
      input = new Scanner(file);
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return input;
  }
}
