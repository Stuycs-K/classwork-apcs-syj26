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
}
