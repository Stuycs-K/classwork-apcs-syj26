public class FibTester {
  public static int fibIter(int n, int f1, int f2) {
    if (n==0) {
      return f2;
    } else {
      return fibIter(n-1, f1+f2, f1);
    }
  }
  public static void main(String[] args) {

  }
}
