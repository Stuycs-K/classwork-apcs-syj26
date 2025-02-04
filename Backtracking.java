public class Backtracking {
/*
  *@param length how long the words must be
  *param word the variable to store the partial solution (Initial call should start at "")
  *param letters will contain the unique* letters allowed in the string.
  *      (*unique: You can assume there are no duplicates)
  *@return the number of words that have no adjacent matching letters
  *        using the letters provided. This is possibly zero if there
  *        is only one unique letter provided, but that is an edge case.
  *Repetition allowed except when letters are adjacent e.g. "abababa" is allowed.
  */
  public static long countNoDoubleLetterWords(int length,String word, String letters){
    if (length==0) {
      return 1;
    } else if (word.length()==0){
      long sum=0;
      for (int i=0; i<letters.length(); i++) {
        sum+=countNoDoubleLetterWords(length-1, word+letters.charAt(i), letters);
      }
      return sum;
    } else {
      long sum=0;
      for (int i=0; i<letters.length(); i++) {
        if (word.charAt(word.length()-1)!=letters.charAt(i)) {
          sum+=countNoDoubleLetterWords(length-1, word+letters.charAt(i), letters);
        }
      }
      return sum;
    }
  //Hint: not a wrapper method, but you must call it starting with "" as your word
  // e.g. countNoDoubleLetterWords(5,"","abc")
  }
  public static void main(String[] args) {
    System.out.println(countNoDoubleLetterWords(3, "", "abc"));
    System.out.println(countNoDoubleLetterWords(0, "", "abc"));
    System.out.println(countNoDoubleLetterWords(1, "", "a"));
    System.out.println(countNoDoubleLetterWords(10, "", "a"));
    System.out.println(countNoDoubleLetterWords(5, "", "abcde"));
    System.out.println(countNoDoubleLetterWords(5, "", "abcdefghij"));
    System.out.println(countNoDoubleLetterWords(7, "", "abcdefghijk"));
  }
}
