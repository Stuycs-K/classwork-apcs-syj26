import java.util.ArrayList;

public class ArrayListPractice {
  public static ArrayList<String> createRandomArray (int size) {
    ArrayList<String> arr = new ArrayList<String>(size);
    String a = "";
    int n = 0;
    for (int i=0; i<size; i++) {
      n=(int)(11*Math.random());
      if (n==0) {
        a="";
      } else {
        a=""+n;
      }
      arr.add(a);
    }
    return arr;
  }

  public static void main(String[] args) {
    System.out.println(createRandomArray(5));
  }
}
