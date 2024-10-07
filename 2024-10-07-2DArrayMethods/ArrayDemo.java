import java.util.Arrays;
public class ArrayDemo{
  public static void main(String[]args){
    //write your tests here!
    //You can now use Arrays.toString(yourArray) instead of writing arrayToString again.
    //Compare Arrays.toString(yourArray) to YOUR arrayToString() method to make sure yours is correct
    //do not use any other Arrays.method()
    int[][] arr = {{1, 4, 3, 4}, {}, {0, 0, 0}, {-5, 4}, {0, -3, 5, 0, -243}};
    System.out.println("Number of zeros in "+Arrays.deepToString(arr)+": "+countZeros2D(arr));
    System.out.println(arrToString(arr).equals(Arrays.deepToString(arr)));
    arr = new int[6][3];
    System.out.println("Number of zeros in "+Arrays.deepToString(arr)+": "+countZeros2D(arr));
    System.out.println(arrToString(arr).equals(Arrays.deepToString(arr)));
    arr = new int[][] {{4, 3, 0}, {-1, 5, -43, 0}};
    System.out.println("Number of zeros in "+arrToString(arr)+": "+countZeros2D(arr));
    System.out.println(arrToString(arr).equals(Arrays.deepToString(arr)));
  }

  //0. Include your prior methods to help you print a 1D/2D array of ints.
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

  //The name of different methods can be the same,
  //as long as the parameters are different! (type and/or quantity must be different)
  //Pro tip: you should be using your 1D arrToString in this method!
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

  //1. Calculate and return how many elements equal zero in the 2D array.
  public static int countZeros2D(int[][] nums){
    int count=0;
    for (int i=0; i<nums.length; i++) {
      for (int j=0; j<nums[i].length; j++) {
        if (nums[i][j]==0) {count++;}
      }
    }
    return count;
  }

  //2. Calculate the sum of a 2d array
  /*Return the sum of all of the values in the 2D array
   *Use a nested loop instead of a helper method*/
  public static int arr2DSum(int[][]nums){
    return 0;
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

  //5. Rotate an array by returning a new array with the rows and columns swapped.
  //   You may assume the array is rectangular and neither rows nor cols is 0.
  //   e.g. swapRC({{1,2,3},{4,5,6}}) returns {{1,4},{2,5},{3,6}}
  public static int[][] swapRC(int[][]nums){
    int[][] ans= new int[nums[0].length][nums.length];
    for (int i=0; i<nums[0].length; i++) {
      for (int j=0; j<nums.length; j++) {
          ans[i][j]=nums[j][i];
      }
    }
    return ans;
  }

  //6. Make an HTML table by putting a table tag around the entire 2d array,
  //   tr tags around each row, and td tags around each value.
  //   You may use a helper method
  //   Note there is no whitespace in the string, it all one line with no spaces/tabs.
  //   e.g. htmlTable(new int[][]{{1,2},{3}})  returns:
  // "<table><tr><td>1</td><td>2</td></tr><tr><td>3</td></tr></table>"
  public static String htmlTable(int[][]nums){
    return "";
  }
}
