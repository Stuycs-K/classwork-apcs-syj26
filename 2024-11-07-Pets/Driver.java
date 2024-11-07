public class Driver {
  public static void main(String[] args){
    Animal kitty = new Animal("meow", 2, "Mittens");
    kitty.speak();
    Bird pigeon = new Bird("Squaaaak!", 10, "Doug", 6.4, "gray");
    pigeon.speak();
  }
}
