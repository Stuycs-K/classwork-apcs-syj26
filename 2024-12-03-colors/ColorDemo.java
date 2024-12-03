public class ColorDemo {
  //includes bold+underline
  public static String format(String bg, String fg) {
    return "\u001b[1;4;"+bg+";"+fg+"m";
  }
  public static final String RESET = "\u001b[0m";
  public static final String RED = format("101", "38;2;82;6;6");
  public static final String YELLOW = format("103", "38;2;153;123;24");
  public static final String BLUE = format("106", "34");
  public static final String PURPLE = format("48;2;196;157;235", "38;2;71;16;125");
  public static final String GREEN = format("102", "38;2;15;102;13");
  public static final String PINK = format("48;2;252;187;245", "35");
  public static final String BLACK = format("48;2;133;133;133", "38;2;0;0;0");
  public static final String WHITE = format("40", "37");
  public static void main(String[] args) {
    System.out.print("\u001b[31mRed");
    System.out.print(" \u001b[0mfish ");
    System.out.print("\u001b[36mBlue");
    System.out.print(" \u001b[0mfish ");
    System.out.println("\n");
    System.out.println("I could be "+RED+"red"+RESET);
    System.out.println("Or I could be "+YELLOW+"yellow"+RESET);
    System.out.println("I could be "+BLUE+"blue"+RESET);
    System.out.println("Or I could be "+PURPLE+"purple"+RESET);
    System.out.println("I could be "+GREEN+"green"+RESET);
    System.out.print("Or "+PINK+"pink"+RESET);
    System.out.print(" or "+BLACK+"black"+RESET);
    System.out.println(" or "+WHITE+"white"+RESET);
    String[] arr="I could be every color you like".split("");
    String[] designs=new String[]{RED, YELLOW, BLUE, PURPLE, GREEN, PINK, BLACK};
    for (int i=0; i<arr.length; i++) {
      System.out.print(designs[i%designs.length]+arr[i]);
    }
    System.out.print(RESET);
  }
}
