import java.util.Scanner;
public class Game {
  public static void printInfo(Adventurer a) {
    System.out.print(a.getName()+" HP: "+a.getHP()+"/"+a.getmaxHP()+" ");
    System.out.println(a.getSpecialName()+": "+a.getSpecial()+"/"+a.getSpecialMax());
  }

  public static void randomAction(Adventurer actioner, Adventurer other) {
    int action = (int) (3*Math.random());
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
    boolean quitted=false;
    while (!done) {
      boolean invalid=false;
      printInfo(wz); printInfo(cw);
      System.out.println("Type: (a)ttack / (sp)ecial / (su)pport / quit");
      String command = userInput.nextLine();
      if (command.equals("quit")) {
        done=true;
        quitted=true;
      } else if (command.equals("a") || command.equals("attack")) {
        System.out.println(wz.attack(cw));
      } else if (command.equals("sp") || command.equals("special")) {
        System.out.println(wz.specialAttack(cw));
      } else if (command.equals("su") || command.equals("support")) {
        System.out.println(wz.support());
      } else {
        invalid=true;
        System.out.println("Please try again.");
      }
      if (cw.getHP()<=0) {
        done=true;
        System.out.println(cw+" has died. "+wz+" is the winner of the fight!");
      }
      if (!invalid && !done) {
        randomAction(cw, wz);
      }
      if (wz.getHP()<=0) {
        done=true;
        System.out.println(wz+" has died. "+cw+" is thse winner of the fight!");
      }
      System.out.println();
    }
  }
}
