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

  public static int[] returnCopy(int[] ary) {
    int[] ans=new int[ary.length];
    for (int i=0; i<ary.length; i++) {
      ans[i]=ary[i];
    }
    return ans;
  }

  public static int[] concatArray(int[] ary1, int[] ary2) {
    int[] ans=new int[ary1.length+ary2.length];
    for (int i=0; i<ary1.length; i++) {
      ans[i]=ary1[i];
    }
    for (int i=ary1.length; i<ans.length; i++) {
      
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3};
    testCopy(a, returnCopy(a));
    a = new int[0];
    testCopy(a, returnCopy(a));
    a = new int[]{5, 2, 78, 2, 82, 7};
    testCopy(a, returnCopy(a));
    int[] b = {1, 200, 3};
    testConcat(a, b);
    a = new int[0];
    b = new int[0];
    testConcat(a, b);
    a = new int[0];
    b = new int[]{0, 7, 4};
    testConcat(a, b);
    a = new int[]{0, 7, 4};
    b = new int[0];
    testConcat(a, b);
    a = new int[]{1, 4, 2, 5};
    b = new int[]{76, 3, 8, 12, 543};
    testConcat(a, b);
    a = new int[]{1, 4, 0, 5};
    b = new int[]{76, 3, 8, 12};
    testConcat(a, b);
    b = new int[]{1, 4, 2, 5};
    testConcat(new int[]{1, 4, 2, 5}, b);
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

  public static void testConcat(int[] ary1, int[] ary2) {
    System.out.println(arrayToString(ary1));
    System.out.println(arrayToString(ary2));
    System.out.println(concatArray(ary1, ary2));
  }
}
