public class Driver{
  public static void printInfo(Adventurer a) {
    System.out.print(a.getName()+" HP: "+a.getHP()+"/"+a.getmaxHP()+" ");
    System.out.println(a.getSpecialName()+": "+a.getSpecial()+"/"+a.getSpecialMax());
  }
  public static void main(String[] args) {
    Adventurer p1 = new Wizard("alicia");
    Adventurer p2 = new Wizard("anastasia", 20);
    Adventurer p3 = new Wizard("ashley", 15, 70);
    printInfo(p1); printInfo(p2); printInfo(p3);
    System.out.println(p1.attack(p2));
    printInfo(p2);
    System.out.println(p3.support(p2));
    printInfo(p2);
  }
}
