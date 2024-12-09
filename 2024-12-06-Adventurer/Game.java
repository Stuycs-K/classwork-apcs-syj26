import java.util.Scanner;
public class Game {
  public static void printInfo(Adventurer a) {
    System.out.print(a.getName()+" HP: "+a.getHP()+"/"+a.getmaxHP()+" ");
    System.out.println(a.getSpecialName()+": "+a.getSpecial()+"/"+a.getSpecialMax());
  }

  public static void main (String[] args) {
    Scanner userInput = new Scanner(System.in);
    CodeWarrior cw = new CodeWarrior();
    Wizard wz = new Wizard("Oz");
    boolean done=false;
    while (!done) {
      printInfo(wz); printInfo(cw);
      System.out.println("Type: (a)ttack / (sp)ecial / (su)pport / quit");
      String command = userInput.nextLine();
      if (command.equals("a") || command.equals("attack")) {
        System.out.println(wz.attack(cw));
      } else if (command.equals("sp") || command.equals("special")) {
        System.out.println(wz.specialAttack(cw));
      } else if (command.equals("su") || command.equals("support")) {
        System.out.println(wz.support());
      } else if (command.equals("quit")) {
        done=true;
      } else {

      }
      System.out.println();
    }
  }
}
