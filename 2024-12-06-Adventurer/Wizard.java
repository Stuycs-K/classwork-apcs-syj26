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

  //hurt or hinder the target adventurer
  public String attack(Adventurer other) {
    int decHP=(int)(Math.random()*(other.getHP()+1));
    other.setHP(other.getHP()-decHP);
    return getName()+" decreased "+other.getName()+"'s HP by "+decHP;
  }

  //heall or buff the target adventurer
  public String support(Adventurer other) {
    int incHP=(int)(Math.random()*(other.getHP()+1));
    int incSpecial=(int)(Math.random()*(other.getSpecial()/2));
    other.setHP(other.getHP()+incHP);
    other.setSpecial(other.getSpecial()+incSpecial);
    return getName()+" increased "+other.getName()+"'s HP by "+incHP+", increased "+other.getName()+"'s "+getSpecialName()+" by "+incSpecial;
  }

  //heall or buff self
  public String support() {
    int incHP=(int)(Math.random()*(getHP()+1));
    setHP(getHP()+incHP);
    return "increased own HP by "+incHP;
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other) {
    int decSpecial=(int)(Math.random()*(other.getSpecial()/2));
    other.setSpecial(other.getSpecial()-decSpecial);
    return getName()+" decreased "+other.getName()+"'s "+getSpecialName()+" by "+decSpecial;
  }
}
