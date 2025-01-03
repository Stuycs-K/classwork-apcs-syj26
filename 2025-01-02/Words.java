public class Words {
  public static void makeWords(int remainingLetters, String result, String alphabet) {
    if (remainingLetters==0) {
      System.out.println(result);
    } else {
      for (int i=0; i<alphabet.length(); i++) {
        makeWords(remainingLetters-1, result+alphabet.charAt(i), alphabet);
      }
    }
  }

  public static String toWords(int n) {
    String[] teens = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String[] ten1 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    if (n<20) {
      return teens[n];
    } else if (n<100) {
      if (n%10 != 0) {
        return ten1[n/10-2]+"-"+teens[n%10];
      } else {
        return ten1[n/10-2];
      }
    } else {
      return "too big";
    }
  }
  public static void main(String[] args) {
    makeWords(2, "", "abc");
    System.out.println("");
    makeWords(3, "", "xy");
    System.out.println("");
    makeWords(5, "", "01");
    System.out.println("");
    makeWords(10, "", "a");
    System.out.println("");
    makeWords(1, "", "abcdefghijklmnopqrstuvwxyz");
    System.out.println("");
    makeWords(0, "", "abcdefghijklmnopqrstuvwxyz");
    for (int i=0; i<100; i++) {
      System.out.println(toWords(i));
    }
  }
}
