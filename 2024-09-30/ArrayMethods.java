public class ArrayMethods {
    //1. Write both your names + emails at the top of the document as a comment.
    // Sophia Jin sjin60@stuy.edu sophiaj44@nycstudents.net Tasnim Islam tislam50@stuy.edu tasnimi6@nycstudent.net
    //2. Copy your arrToString method from before.

    /**Return a String that represets the array in the format:
    * "[2, 3, 4, 9]"
    * Note the comma+space between values, and between values
    */
    public static String arrToString(int[]ary){
      String s = "[";
      for (int i = 0; i < ary.length; i++ ){
              s += ary[i];
              if (i<ary.length-1) {
                s += ", ";
              }
      }
      return s + "]";
    }

    //3. Write arrToString, with a 2D array parameter.
    //Note: Different parameters are allowed with the same function name.
    /**Return a String that represets the 2D array in the format:
      * "[[2, 3, 4], [5, 6, 7], [2, 4, 9]]"
      * Note the comma+space between values, and between arrays
      * You are encouraged to notice that you may want to re-use
      * previous code, but you should NOT duplicate that code. (Don't copy/paste or retype it)
      */
    public static String arrToString(int[][]ary){
      String ans="[";
      for (int i=0; i<ary.length; i++) {
        ans+=arrToString(ary[i]);
        if (i<ary.length-1) {
          ans+=", ";
        }

      }
        return ans+"]";
    }

    /*Return the sum of all of the values in the 2D array */
    public static int arr2DSum(int[][]nums){
      //use a nested loop to solve this
      int sum=0;
      for (int i=0; i<nums.length; i++) {
        for (int j=0; j<nums[i].length; j++) {
            sum+=nums[i][j];
        }
      }
      return sum;//place holder return value so it compiles.
    }

    /**Rotate an array by returning a new array with the rows and columns swapped.
      * You may assume the array is rectangular and neither rows nor cols is 0.
      * e.g. swapRC({{1,2,3},{4,5,6}}) returns {{1,4},{2,5},{3,6}}
      */
    public static int[][] swapRC(int[][]nums){
      int[][] ans= new int[nums[0].length][nums.length];
      for (int i=0; i<nums[0].length; i++) {
        for (int j=0; j<nums.length; j++) {
            ans[i][j]=nums[j][i];
        }
      }
      return ans;
    }

    //3. Modify a given 2D array of integer as follows:
    //Replace all the negative values:
    //-When the row number is the same as the column number replace
    //that negative with the value 1
    //-All other negatives replace with 0
    public static void replaceNegative(int[][] vals){
      for (int i=0; i<vals.length; i++) {
        for (int j=0; j<vals[i].length; j++) {
          if (vals[i][j]<0) {
            if (j==i) {vals[i][j]=1;}
            else {vals[i][j]=0;}
          }
        }
      }
    }

    //4. Make a copy of the given 2d array.
    //When testing : make sure that changing the original does NOT change the copy.
    //DO NOT use any built in methods that "copy" an array.
    //You SHOULD write a helper method for this.
    //If you don't see a good way to do that, you should stop and look at prior methods.
    public static int[] copy(int[] ary) {
      int[] ans=new int[ary.length];
      for (int i=0; i<ary.length; i++) {
        ans[i]=ary[i];
      }
      return ans;
    }

    public static int[][] copy(int[][] nums){
      int[][] ans=new int[nums.length][];
      for (int i=0; i<nums.length; i++) {
        ans[i]=copy(nums[i]);
      }
      return ans;
    }

    public static void main(String[] args) {
      int[][] test = {{1,2,3}, {4,5,6}, {7,8,9}};
      System.out.println(arrToString(test));
      test = new int[][] {{1,3,5}, {1,2},{}};
      System.out.println(arrToString(test));
      test = new int[3][5];
      System.out.println(arrToString(test));

      System.out.println(arr2DSum(test));
      test = new int[1][0];
      System.out.println(arr2DSum(test));
      test = new int[][]{{4, 34, -43}, {}, {13, 0, 34, -1}, {43, 2}};
      System.out.println(arr2DSum(test));
      test = new int[][]{{1, 2, 3}};
      System.out.println(arr2DSum(test));
      test = new int[][]{{1}};
      System.out.println(arr2DSum(test));
      test = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
      System.out.println(arr2DSum(test));

      test = new int[][]{{1,2,3},{4,5,6}};
      System.out.println(arrToString(swapRC(test)));
      test = new int[][]{{1,2,3},{4,5,6}, {7, 8, 9}};
      System.out.println(arrToString(swapRC(test)));
      test = new int[][]{{1,2,3,4},{5, 6, 7, 8}};
      System.out.println(arrToString(swapRC(test)));
      test = new int[4][6];
      System.out.println(arrToString(swapRC(test)));

      test = new int[][]{{-1,2,3},{4,-5,-6}};
      replaceNegative(test);
      System.out.println(arrToString(test));
      test = new int[][]{{4, 34, -43}, {}, {13, 0, -34, -1}, {-43, -2}};
      replaceNegative(test);
      System.out.println(arrToString(test));
      test = new int[][]{{0, 34, -43}, {}, {13, 0, 0, -1}, {-43, -2}};
      replaceNegative(test);
      System.out.println(arrToString(test));
      test = new int[][]{{43, 87, -5, -634}, {5, 7, -9}, {523, -57}, {-34}, {}, {7, -3, -48, -1, 0, -4}};
      replaceNegative(test);
      System.out.println(arrToString(test));

      test = new int[][]{{-1,2,3},{4,-5,-6}};
      int[][] arr=copy(test);
      test=new int[2][3];
      System.out.println(arrToString(arr));
      test = new int[][]{{}, {}, {3, 4, 2}};
      arr=copy(test);
      test=new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
      System.out.println(arrToString(arr));
    }
  }
