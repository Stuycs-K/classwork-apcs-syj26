import java.util.*;
import java.io.*;

public class Advent2016D5P1 {
    public static int[] binarify(int n) {//turns 0<=n<256 into binary array
        int[] ans=new int[8];
        for (int i=0; i<8; i++) {
            ans[7-i]=n%2;
            n=n/2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int count=0; int index=0; String hashee; int[] padded;
        while (count<8) {
            hashee="ojvtpuvg"+index;
            padded = new int[512];
            for (int i=0; i<hashee.length(); i++) {
                int[] arr = binarify(hashee.charAt(i));
                for (int j=0; j<8; j++) {
                    padded[8*i+j]=arr[j];
                }
            }
            padded[hashee.length()*8]=1;
            int hasheeLength=hashee.length()*8;
            for (int i=7; i>=0; i--) {
                padded[504+i]=hasheeLength%2;
                hasheeLength/=2;
            }
            System.out.println(Arrays.toString(padded));
            index++;
            count=8;//delete later obvs
        }
    }
}