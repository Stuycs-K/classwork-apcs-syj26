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

  public static void testMakeReversedList(ArrayList<String> arr) {
    System.out.println("Before: "+arr);
    System.out.println("After: "+makeReversedList(arr));
  }

  public static ArrayList<String> makeReversedList( ArrayList<String> original){
  //return a new ArrayList that is in the reversed order of the original.
    ArrayList<String> r = new ArrayList<String> (original.size());
    for (int i=0; i<original.size(); i++) {
      r.add("");
    }
    for (int i = original.size()-1; i >= 0; i--){
      r.set(original.size()-1-i, original.get(i));
    }
    return r;
  }

  public static void testMixLists(ArrayList<String> arr1, ArrayList<String> arr2) {
    System.out.println("Before: "+arr1);
    System.out.println("Before: "+arr2);
    System.out.println("After: "+mixLists(arr1, arr2));
  }

  public static ArrayList<String> mixLists( ArrayList<String> a,  ArrayList<String> b){
  //return a new ArrayList that has all values of a and b in alternating order that is:
  //a[0], b[0], a[1], b[1]...
  //If one list is longer than the other, just attach the remaining values to the end.
    ArrayList<String> arr = new ArrayList<String>(a.size()+b.size());
    int minSize=Math.min(a.size(), b.size());
    for (int i=0; i<minSize; i++) {
      arr.add(a.get(i));
      arr.add(b.get(i));
    }
    if (a.size()>b.size()) {
      for (int i=minSize; i<a.size(); i++) {
        arr.add(a.get(i));
      }
    }
    if (b.size()>a.size()) {
      for (int i=minSize; i<b.size(); i++) {
        arr.add(b.get(i));
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    System.out.println(createRandomArray(5));
    System.out.print("\n");
    for (int i = 0; i < 5; i++){
      testReplaceEmpty(createRandomArray(15));
    }
    System.out.print("\n");
    for (int i = 0; i < 5; i++){
      testMakeReversedList(createRandomArray(15));
    }
    System.out.print("\n");
    for (int i = 0; i < 5; i++){
      testMixLists(createRandomArray(15), createRandomArray(15));
    }
  }

}
