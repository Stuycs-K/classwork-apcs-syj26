import java.util.*;
import java.io.*;

public class Advent2016D5P1 {
    public static int[] binaryify(int n, int digits) {//turns 0<=n<256 into binary array
        int[] ans=new int[digits];
        for (int i=0; i<digits; i++) {
            ans[digits-1-i]=n%2;
            n=n/2;
        }
        return ans;
    }
    public static int[] binaryAnd(int[] arr1, int[] arr2) { //assume arrays same length
        int[] ans = new int[arr1.length];
        for (int i=0; i<ans.length; i++) {
            ans[i]=arr1[i]*arr2[i];
        }
        return ans;
    }
    public static int[] hexAnd(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int[] prod;
        for (int i=0; i<ans.length; i++) {
            prod=binaryAnd(binaryify(arr1[i], 4), binaryify(arr2[i], 4));
            ans[i]=8*prod[0]+4*prod[1]+2*prod[2]+prod[3];
        }
        return ans;
    }
    public static int[] binaryOr(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        for (int i=0; i<ans.length; i++) {
            ans[i]=arr1[i]+arr2[i]-arr1[i]*arr2[i];
        }
        return ans;
    }
    public static int[] hexOr(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int[] prod;
        for (int i=0; i<ans.length; i++) {
            prod=binaryOr(binaryify(arr1[i], 4), binaryify(arr2[i], 4));
            ans[i]=8*prod[0]+4*prod[1]+2*prod[2]+prod[3];
        }
        return ans;
    }
    public static int[] binaryXor(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        for (int i=0; i<ans.length; i++) {
            ans[i]=(arr1[i]+arr2[i])%2;
        }
        return ans;
    }
    public static int[] hexXor(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int[] prod;
        for (int i=0; i<ans.length; i++) {
            prod=binaryXor(binaryify(arr1[i], 4), binaryify(arr2[i], 4));
            ans[i]=8*prod[0]+4*prod[1]+2*prod[2]+prod[3];
        }
        return ans;
    }
    public static int[] binaryNot(int[] arr) {
        int[] ans = new int[arr.length];
        boolean leading = true;
        for (int i=0; i<ans.length; i++) {
            if (arr[i]==1) {leading=false;}
            if (!leading) {
                ans[i]=1-arr[i];
            }
        }
        return ans;
    }
    public static int[] hexNot(int[] arr) {
        int[] ans = new int[arr.length];
        int[] prod;
        for (int i=0; i<ans.length; i++) {
            prod=binaryNot(binaryify(arr[i], 4));
            ans[i]=8*prod[0]+4*prod[1]+2*prod[2]+prod[3];
        }
        return ans;
    }
    //assume arr1 and arr2 are the same size, add mod n
    public static int[] add(int[] arr1, int[] arr2, int mod) {
        int[] ans = new int[arr1.length];
        int regroup=0;
        for (int i=arr1.length-1; i>=0; i--) {
            ans[i]=(arr1[i]+arr2[i]+regroup)%mod;
            if (arr1[i]+arr2[i]+regroup>=16) {
                regroup=1;
            } else {
                regroup=0;
            }
        }
    }
    public static int[] F(int[] B, int[] C, int[] D) {
        return hexOr(hexAnd(B, C), hexAnd(hexNot(B), D));
    }
    public static int[] G(int[] B, int[] C, int[] D) {
        return hexOr(hexAnd(B, D), hexAnd(C, hexNot(D)));
    }
    public static int[] H(int[] B, int[] C, int[] D) {
        return hexXor(hexXor(B, C), D);
    }
    public static int[] I(int[] B, int[] C, int[] D) {
        return hexXor(C, hexOr(B, hexNot(D)));
    } 
    public static void main(String[] args) {
        int count=0; int index=0; String hashee; int[] padded; 
        int[][] words=new int[16][8];
        int[] A = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        int[] B = new int[]{8, 9, 10, 11, 12, 13, 14, 15};
        int[] C = new int[]{15, 14, 13, 12, 11, 10, 9, 8};
        int[] D = new int[]{7, 6, 5, 4, 3, 2, 1, 0};
        while (count<8) {
            hashee="ojvtpuvg"+index;
            padded = new int[512];
            for (int i=0; i<hashee.length(); i++) {
                int[] arr = binaryify(hashee.charAt(i), 8);
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
            for (int i=0; i<16; i++) {
                for (int j=0; j<8; j++) {
                    words[i][j]=8*padded[32*i+4*j]+4*padded[32*i+4*j+1]+2*padded[32*i+4*j+2]+padded[32*i+4*j+3];
                }
            }
            System.out.println(Arrays.deepToString(words));
            System.out.println(Arrays.toString(F(B, C, D)));
            B=new int[] {2, 12, 3, 4, 13, 15, 10, 2};
            C=new int[] {13, 14, 1, 6, 7, 3, 11, 14};
            D=new int[] {4, 11, 9, 7, 6, 2, 8, 2};
            System.out.println(Arrays.toString(G(B, C, D)));
            B=new int[] {13, 5, 0, 7, 1, 3, 6, 7};
            C=new int[] {12, 0, 5, 8, 10, 13, 14, 2};
            D=new int[] {6, 3, 12, 6, 0, 3, 13, 7};
            System.out.println(Arrays.toString(H(B, C, D)));
            B=new int[] {7, 13, 5, 0, 2, 0, 6, 3};
            C=new int[] {8, 11, 3, 13, 7, 1, 5, 13};
            D=new int[] {1, 13, 14, 3, 10, 7, 3, 9};
            System.out.println(Arrays.toString(I(B, C, D)));
            
            index++;
            count=8;//delete later obvs
        }
    }
}