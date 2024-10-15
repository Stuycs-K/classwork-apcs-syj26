public class Demo{

  /*
  Write this method third. Test it then move on
  to the others.
  */
  public static double distance(Point a, Point b){
    return Math.sqrt(Math.pow(a.getX()-b.getX(), 2.0) + Math.pow(a.getY()-b.getY(), 2.0));
  }

  public static void main(String[]args){
    Point p1 = new Point(1,1);
    System.out.println(p1);
    System.out.println(p1==new Point(1, 1));
    Point p2 = new Point(-1,-1);
    System.out.println(p2);
    System.out.println(p2==new Point(-1, -1));
    p1=new Point(p2);
    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p1==p2);
    Point p3 = new Point(3,4);
    System.out.println( p3);
    System.out.println("Distance between p1 and p2");
    System.out.println( distance(p1,p2));
    System.out.println( distance(p2,p1));
    System.out.println(p1.distanceTo(p2));
    System.out.println(p2.distanceTo(p1));
    System.out.println(Point.distance(p1, p2));
    System.out.println(Point.distance(p2, p1));
    System.out.println("Distance between p1 and p3");
    System.out.println( distance(p1,p3));
    System.out.println( distance(p3,p1));
    System.out.println(p1.distanceTo(p3));
    System.out.println(p3.distanceTo(p1));
    System.out.println(Point.distance(p1, p3));
    System.out.println(Point.distance(p3, p1));
    System.out.println("Distance between p3 and (0, 0)");
    System.out.println( distance(new Point(0,0), p3));
    System.out.println( distance(p3, new Point(0,0)));
    System.out.println(new Point(0, 0).distanceTo(p3));
    System.out.println(p3.distanceTo(new Point(0, 0)));
    System.out.println(Point.distance(new Point(0, 0), p3));
    System.out.println(Point.distance(p3, new Point(0, 0)));
    System.out.println("");
    System.out.println( Point.distance(p1,p2));
    System.out.println( p1.distanceTo(p2));

    Point v1=new Point(0, 0);
    Point v2=new Point(1, 0);
    Point v3=new Point(0.5, Math.sqrt(3)/2);
    System.out.println("Side lengths");
    System.out.println(v1.distanceTo(v2));
    System.out.println(distance(v2, v3));
    System.out.println(Point.distance(v3, v1));
  }
}
