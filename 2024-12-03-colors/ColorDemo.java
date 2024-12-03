public class ColorDemo {
  //includes bold+underline
  public static String format(String bg, String fg) {
    return "\u001b[1;4;"+bg+";"+fg+"m";
  }
  public static final String RESET = "\u001b[0m";
  public static void main(String[] args) {
    System.out.print("\u001b[31mRed");
    System.out.print(" \u001b[0mfish ");
    System.out.print("\u001b[36mBlue");
    System.out.print(" \u001b[0mfish ");
    System.out.println("\n");
    System.out.println("I could be "+format("101", "38;2;82;6;6")+"red"+RESET);
    System.out.println("Or I could be \u001b[1;4;103;38;2;153;123;24myellow\u001b[0m");
    System.out.println("I could be \u001b[1;4;106;34mblue\u001b[0m");
    System.out.println("Or I could be purple\u001b[0m");
    System.out.println("I could be green\u001b[0m");
    System.out.println("Or pink\u001b[0m or black\u001b[0m or white\u001b[0m");
    System.out.println("I could be every color you like\u001b[0m");
  }
}
