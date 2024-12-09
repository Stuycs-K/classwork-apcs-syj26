import java.util.Scanner;
public class Game {
  public static void printInfo(Adventurer a) {
    System.out.print(a.getName()+" HP: "+a.getHP()+"/"+a.getmaxHP()+" ");
    System.out.println(a.getSpecialName()+": "+a.getSpecial()+"/"+a.getSpecialMax());
  }

  public static void randomAction(Adventurer actioner, Adventurer other) {
    int action = (int) Math.random(3);
    if (action==0) {
      System.out.println(actioner.attack(other));
    } else if (action==1) {
      System.out.println(actioner.specialAttack(other));
    } else {
      System.out.println(actioner.support());
    }
  }

  public static void main (String[] args) {
    Scanner userInput = new Scanner(System.in);
    Adventurer cw = new CodeWarrior();
    Adventurer wz = new Wizard("Oz");
    boolean done=false;
    while (!done) {
      printInfo(wz); printInfo(cw);
      System.out.println("Type: (a)ttack / (sp)ecial / (su)pport / quit");
      String command = userInput.nextLine();
      if (command.equals("a") || command.equals("attack")) {
        System.out.println(wz.attack(cw));
        randomAction(cw, wz);
      } else if (command.equals("sp") || command.equals("special")) {
        System.out.println(wz.specialAttack(cw));
        randomAction(cw, wz);
      } else if (command.equals("su") || command.equals("support")) {
        System.out.println(wz.support());
        randomAction(cw, wz);
      } else if (command.equals("quit")) {
        done=true;
      } else {

      }
      System.out.println();
    }
  }
}
