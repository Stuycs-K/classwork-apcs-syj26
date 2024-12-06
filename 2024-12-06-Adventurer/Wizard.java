public class Wizard extends Adventurer {
  private int mana;
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
}

