import java.util.Arrays;

public class Day16 {
    public static int[] dragonCurve(int[] input, int minLength) {
        int[] b = new int[input.length];
        for (int i=0; i<b.length; i++) {b[i]=(input[b.length-1-i]+1)%2;}
        int[] ans = new int[b.length*2+1];
        for (int i=0; i<b.length; i++) {ans[i]=input[i];}
        ans[b.length]=0;
        for (int i=b.length+1; i<ans.length; i++) {ans[i]=b[i-b.length-1];}
        if (ans.length>=minLength) {
            return Arrays.copyOf(ans, minLength);
        }
        return dragonCurve(ans, minLength);
    }
    public static int[] checksum(int[] data) {
        if (data.length%2 == 1) {return data;}
        int[] ans=new int[data.length/2];
        for (int i=0; i<ans.length; i++) {
            ans[i]=(data[2*i]+data[2*i+1]+1)%2;
        }
        return checksum(ans);
    }
    public static void main(String[] args) {
        String[] stringput="10001110011110000".split("");
        int[] input=new int[stringput.length];
        for (int i=0; i<input.length; i++) {
            input[i]=Integer.parseInt(stringput[i]);
        }
        int[] data=dragonCurve(input, 35651584);
        int[] checksum=checksum(data);
        String ans="";
        for (int i=0; i<checksum.length; i++) {
            ans+=checksum[i];
        }
        System.out.println(ans);
    }
}