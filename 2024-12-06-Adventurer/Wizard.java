public class Wizard extends Adventurer {
  private int mana, manaMax;

  //constructors
  public Wizard(String name) {
    super(name);
    mana=50;
    manaMax=100;
  }

  public Wizard(String name, int hp) {
    super(name, hp);
    mana=50;
    manaMax=100;
  }

  public Wizard(String name, int hp, int mana) {
    super(name, hp);
    this.mana=mana;
    manaMax=100;
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
    return manaMax;
  }

  //hurt or hinder the target adventurer
  public String attack(Adventurer other) {
    int decHP=(int)(Math.random()*4+1);
    other.applyDamage(decHP);
    String[] messages=new String[]{" smacks "+other+" with their magic staff", 
    " karate kicks "+other+" in the head", 
    " calls "+other+" a failure, dealing emotional damage", 
    " turns off "+other+"'s WiFi"};
    int index=(int)(Math.random()*messages.length);
    return this+messages[index]+", decreasing "+other+"'s HP by "+decHP+".";
  }

  //heall or buff the target adventurer
  public String support(Adventurer other) {
    int incHP=(int)(Math.random()*4+1);
    int incSpecial=(int)(Math.random()*5+5);
    other.setHP(other.getHP()+incHP);
    other.restoreSpecial(incSpecial);
    String[] messages=new String[]{" gives "+other+" a healing potion",
    " casts a restorative spell on "+other};
    int index=(int)(Math.random()*messages.length);
    return this+messages[index]+" increasing "+other+"'s HP by "+incHP+" and "+other+"'s "+getSpecialName()+" by "+incSpecial+".";
  }

  //heall or buff self
  public String support() {
    int incHP=(int)(Math.random()*(getmaxHP()/2));
    int incSpecial=(int)(Math.random()*5+5);
    setHP(getHP()+incHP);
    restoreSpecial(incSpecial);
    String[] messages=new String[]{" drinks a healing potion",
    " casts a restorative spell on themself",
    " gets over 8 hours of sleep"};
    int index=(int)(Math.random()*messages.length);
    return this+messages[index]+", increasing their HP by "+incHP+" and their "+getSpecialName()+" by "+incSpecial+".";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other) {
    int cost=(int)(Math.random()*(getSpecialMax()/2));
    if (cost<=getSpecial()) {
      int decHP=(int)(Math.random()*5+5);
      other.applyDamage(decHP);
      setSpecial(getSpecial()-cost);
      String[] messages=new String[]{" casts a spell on "+other,
      " throws an explosive potion at "+other,
      " spreads sparkly magical glitter in the air"};
      int index=(int)(Math.random()*messages.length);
      return this+messages[index]+", decreasing "+other+"'s HP by "+decHP+", consuming "+cost+" "+getSpecialName()+".";
    } else {
      return "Not enough "+getSpecialName()+" to attack. Instead, "+attack(other);
    }
    
  }
}
