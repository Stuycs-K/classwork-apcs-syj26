public class Kitty {
  private String name;
  private int age;
  public Kitty(String startName, int startAge) {
    name=startName;
    age=startAge;
  }
  public Kitty() {
    name="Mittens";
    age=2;
  }
  public int getAge() { //NOT STATIC!!!!!
    return age;
  }
  public String getName() {
    return name;
  }
  public void makeOlder() {
    age++;
  }
  public void changeName(String newName) {
    name=newName;
  }
}
