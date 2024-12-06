public class Wizard extends Adventurer {
  private int mana;

  //constructors
  public Wizard(String name) {
    super(name);
    mana=50;
  }

  public Wizard(String name, int hp) {
    super(name, hp);
    mana=50;
  }

  public Wizard(String name, int hp, int mana) {
    super(name, hp);
    this.mana=mana;
  }

  //methods
  public String getSpecialName() {
    return "mana";
  }
  public int getSpecial() {
    return mana;
  }
  public void setSpecial(int n) {
    mana=n;
  }
  public int getSpecialMax() {
    return 100;
  }

  public String attack(Adventurer other) {
    return null;
  }

  //heall or buff the target adventurer
  public String support(Adventurer other) {
    return null;
  }

  //heall or buff self
  public String support() {
    return null;
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other) {
    return null;
  }
}
