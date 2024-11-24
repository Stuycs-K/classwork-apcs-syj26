public class Day21 {
    public static String swap(String str, int X, int Y) {
        if (X>Y) {return swap(str, Y, X);}
        return str.substring(0, X)+str.charAt(Y)+str.substring(X+1, Y)+str.charAt(X)+str.substring(Y+1);
    }
    public static String swap(String str, String X, String Y) {
        int Xpos=str.indexOf(X); int Ypos=str.indexOf(Y);
        if (Xpos>Ypos) {return swap(str, Y, X);}
        return str.substring(0, Xpos)+Y+str.substring(Xpos+1, Ypos)+X+str.substring(Ypos+1);
    }
    //right -> dir>0, left -> dir<0
    public static String rotate(String str, int dir) {
        return str.substring((str.length()-dir)%str.length())+str.substring(0, (str.length()-dir)%str.length());
    }
    public static String rotate(String str, String X) {
        int index=str.indexOf(X);
        str=rotate(str, index+1);
        if (index>=4) {
            return rotate(str, 1);
        }
        return str;
    }
    public static String reverse(String str) {
        String ans="";
        for (int i=str.length()-1; i>=0; i--) {
            ans+=str.charAt(i);
        }
        return ans;
    }
    public static String reverse(String str, int X, int Y) {
        if (X>Y) {return reverse(str, Y, X);}
        return str.substring(0, X)+reverse(str.substring(X, Y+1))+str.substring(Y+1);
    }
    public static String move(String str, int X, int Y) {
        String Xth=""+str.charAt(X);
        str=str.substring(0, X)+str.substring(X+1);
        return str.substring(0, Y)+Xth+str.substring(Y);
    }
    public static void main(String[] args) {
        String str="abcde";
        str=swap(str, 4, 0);
        System.out.println(str);
        str=swap(str, "d", "b");
        System.out.println(str);
        str=reverse(str, 0, 4);
        System.out.println(str);
        str=rotate(str, -1);
        System.out.println(str);
        str=move(str, 1, 4);
        System.out.println(str);
        str=move(str, 3, 0);
        System.out.println(str);
        str=rotate(str, "b");
        System.out.println(str);
        str=rotate(str, "d");
        System.out.println(str);
    }
}