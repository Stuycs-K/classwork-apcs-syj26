import java.util.*;
import java.io.*;

public class Advent2016D6P1 {
    public static int minArrayIndex(int[] arr) {
        int ans=0;
        int smallest=arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i]<smallest) {
                smallest=arr[i];
                ans=i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        try {
            File file = new File("2016d6.txt");
            Scanner sc = new Scanner(file);
            String line;
            int[][][] data = new int[8][26][2];
            for (int i=0; i<8; i++) {
                for (int j=0; j<26; j++) {
                    data[i][j][0]=0; //frequency
                    data[i][j][1]=j; //character
                }
            }
            while (sc.hasNextLine()) {
                line=sc.nextLine();
                for (int i=0; i<8; i++) {
                    data[i][line.charAt(i)-'a'][0]+=1;
                }
            }
            System.out.println(Arrays.deepToString(data));
            int[][] arr=new int[8][26];
            String ans="";
            for (int i=0; i<8; i++) {
                for (int j=0; j<26; j++) {
                    arr[i][j]=100*data[i][j][0]+(25-data[i][j][1]);
                    //hundreds digit(s) is frequency, tens/ones is alphabet in descending order
                    //so smaller letters get bigger %100, thus breaking ties for max
                }
                //reverses the order-reversing thing i did earlier
                //so that we actually get what letter it corresponds to
                ans+=((char) ((25-arr[i][Advent2016D4P1.maxArrayIndex(arr[i])]%100)+'a'));
                arr[i][Advent2016D4P1.maxArrayIndex(arr[i])]=0;
            }
            System.out.println(ans);
            ans="";
            //literally the same thing as before but with min
            //apparently i don't need to break ties, but i'll do it anyway
            for (int i=0; i<8; i++) {
                for (int j=0; j<26; j++) {
                    arr[i][j]=100*data[i][j][0]+data[i][j][1];
                }
                ans+=((char) (arr[i][minArrayIndex(arr[i])]%100+'a'));
                arr[i][minArrayIndex(arr[i])]=0;
            }
            System.out.println(ans);
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
    
}