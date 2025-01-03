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
  }
}
