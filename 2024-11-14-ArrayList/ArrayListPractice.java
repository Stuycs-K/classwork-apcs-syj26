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

  public static void testReplaceEmpty(ArrayList<String> arr) {
    System.out.println("Before: "+arr);
    replaceEmpty(arr);
    System.out.println("After: "+arr);
  }

  public static void replaceEmpty( ArrayList<String> original){
  //Modify the ArrayList such that it has all of the empty strings are
  //replaced with the word "Empty".
    for (int i = 0; i < original.size(); i++){
      if (original.get(i).equals("")){
        original.set(i, "Empty");
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(createRandomArray(5));
    for (int i = 0; i < 5; i++){
      testReplaceEmpty(createRandomArray(15));
    }
  }

}
