public class FibTester {
  public static int fibIter(int n, int f1, int f2) {
    if (n==0) {
      return f2;
    } else {
      return fibIter(n-1, f1+f2, f1);
    }
  }

  public static int fib(int n) {
    return fibIter(n, 1, 0);
  }
  public static void main(String[] args) {
    for (int i=0; i<40; i++) {
      System.out.print(""+i+"th Fibonacci number: ");
      System.out.print(fib(i)+" ");
      System.out.println(fibIter(i, 1, 0));
    }
  }
}
