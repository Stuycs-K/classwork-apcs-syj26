public class Driver {
  public static void main(String[] args) {
    for (int i=0; i<80; i++) {
      Text.go(1, i+1);
      System.out.println(Text.color(i%8+30), Text.background((i+4)%8+30));
      System.out.println("!");
    }
  }
}
