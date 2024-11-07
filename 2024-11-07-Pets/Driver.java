/* When I made the change in the last step,
the output of speak for the bird was different
because it calls the changed getName function.*/
/* Setting a Bird variable type with an Animal object type didn't work.
It caused an incompatible types error, and this aligns with relationship expectations
because not every Animal can be a Bird, since Bird is a subclass of Animal.*/
public class Driver {
  public static void main(String[] args){
    Animal kitty = new Animal("meow", 2, "Mittens");
    kitty.speak();
    Bird pigeon = new Bird("Squaaaak!", 10, "Doug", 6.4, "gray");
    pigeon.speak();
    Animal a1 = new Animal("woof", 3, "Name1"); //fine
    Bird b1 = new Bird("chirp", 5, "Name2", 4.5, "brown"); //fine
    //Bird b2 = new Animal("chirp", 7, "Name3"); //error: incompatible types
    Animal a2 = new Bird("yeehaw", 7, "Name4", 15.7, "neon green");
    a1.speak();
    b1.speak();
    a2.speak();
  }
}
