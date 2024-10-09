public class Driver{
public static void main(String[]args){

//makes a Kitty named Matcha that is 3 years old
Kitty a = new Kitty("Matcha", 3);
System.out.println(a);

//makes a Kitty named Mittens that is 2 years old
Kitty b = new Kitty();
System.out.println(b);

System.out.println(a.getName() + " is "+a.getAge() + " years old.");
//should print "Matcha is 3 years old."

a.makeOlder();
System.out.println(a.getName() + " is "+a.getAge() + " years old.");
//should print "Matcha is 4 years old."

a.makeOlder();
a.changeName("Katya");
b.changeName("Aytak");
b.makeOlder();

System.out.println(a.getName() + " is " + a.getAge() + " years old.");
System.out.println(b.getName() + " is " + b.getAge() + " years old.");
//should print "Katya is 5 years old."
//should print "Aytak is 3 years old."
}
}
