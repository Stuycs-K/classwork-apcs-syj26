public class Point{
  private int x,y;

  public String toString(){
    return "("+getX()+", "+getY()+")";
  }

  //Initialize this Point to have the same values as the other Point.
  public Point(Point other){
    x=other.getX();
    y=other.getY();
    //COMPLETE THIS SECOND
    //Then write test cases.
  }

  //Initialize this Point to have the provided values
  public Point(int x, int y){
    this.x=x;
    this.y=y;
  }

  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }

  public void up(int change) {y+=change;}
  public void down(int change) {y-=change;}
  public void right(int change) {x+=change;}
  public void left(int change) {x-=change;}
  public boolean equals(Point other) {
    return (getX()==other.getX() && getY()==other.getY());
  }


  /*
  Write this method FOURTH, go to the main and do that one first.
  */
  public double distanceTo(Point other){
    return (Math.sqrt(Math.pow(getX()-other.getX(), 2) + Math.pow(getY()-other.getY(), 2)));
  }

  /*
  Write this method last. Re-use (NOT COPY/PASTE) prior work and
  do not write redundant code.
  */
  public static double distance(Point a, Point b){
    return a.distanceTo(b);
  }


}
