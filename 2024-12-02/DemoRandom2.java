import java.util.Random;
public class DemoRandom2{
  public static void main(String[]args){

    //here no seed is provided, so it uses the clock as a seed
    //this can be used to produce a random seed for a different Random object!
    Random rng = new Random();
    int seed = rng.nextInt();
    seed = -1044212732;

    System.out.println("The seed: "+seed);
    rng = new Random(seed);
    for(int i =  0; i < 5; i++ ){
      System.out.print(rng.nextInt() % 1000 + " ");
    }
  }
}
