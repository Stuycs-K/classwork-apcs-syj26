public class MyArrays {
  public static String arrayToString(int[] nums) {
    String ans="[";
    for (int i=0; i<nums.length; i++) {
      ans+=nums[i];
      if (i<nums.length-1) {ans+=", ";}
    }
    ans+="]";
    return ans;
  }

  public static boolean sameValues(int[] ary1, int[] ary2) {
    for (int i=0; i<ary1.length; i++) {
      if (ary1[i]!=ary2[i]) {return false;}
    }
    return true;
  }

  public static void testCopy(int[] ary1, int[] ary2) {
    System.out.println(arrayToString(ary1));
    System.out.println(arrayToString(ary2));
    System.out.println("Same values: "+(sameValues(ary1, ary2)));
    System.out.println("Same address: "+(ary1==ary2));
  }

  public static void main(String[] args) {

  }
}
