import java.util.*;
import java.io.*;

public class Advent2016D4P1 {
    //return sectorID
    public static int sectorID(String line) {
        int left=0; int right=0; int i=line.length()-1; boolean done=false;
        while (i>=0 && !done) {
            if (line.charAt(i)<='9' && line.charAt(i)>='0') {
                right=i+1;
                done=true;
            }
            i--;
        }
        done=false;
        while (i>=0 && !done) {
            if (line.charAt(i)>'9' || line.charAt(i)<'0') {
                left=i+1;
                done=true;
            }
            i--;
        }
        return Integer.parseInt(line.substring(left, right));
    }

    //cuts away the sectorID and checksum
    public static String cut(String line) {
        int end=0;
        int i=0;
        while (end==0) {
            if (line.charAt(i)<='9' && line.charAt(i)>='0') {
                end=i;
            }
            i++;
        }
        return line.substring(0, end-1);
    }
    
    public static int[][] frequencies(String line) {
        int[][] ans = new int[26][2];
        line=cut(line);
        for (int i=0; i<line.length(); i++) {
            if (line.charAt(i)<='z' && line.charAt(i)>='a') {
                ans[line.charAt(i)-'a'][0]+=1;
            }
        }
        for (int i=0; i<26; i++) {
            ans[i][1]=i; //represents the letter
        }
        return ans;
    }

    public static int maxArrayIndex(int[] arr) {
        int ans=0;
        int largest=arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i]>largest) {
                largest=arr[i];
                ans=i;
            }
        }
        return ans;
    }

    public static String trueChecksum(int[][] freq) {
        String ans="";
        char add;
        int[] arr=new int[26];
        for (int i=0; i<26; i++) {
            arr[i]=100*freq[i][0]+(25-freq[i][1]);
            //hundreds digit(s) is frequency, tens/ones is alphabet in descending order
            //so smaller letters get bigger %100, thus breaking ties for max
        }
        for (int i=0; i<5; i++) {
            add=(char) ((25-arr[maxArrayIndex(arr)]%100)+'a');
            //reverses the order-reversing thing i did earlier
            //so that we actually get what letter it corresponds to
            ans+=add;
            arr[maxArrayIndex(arr)]=0;
        }
        return ans;
    }

    public static boolean isReal(String line) {
        return line.substring(line.length()-6, line.length()-1).equals(trueChecksum(frequencies(line)));
    }

    public static void main(String[] args) {
        try {
            File file = new File("2016d4.txt");
            Scanner sc = new Scanner(file);
            String line;
            String cutline;
            int sum=0;
            int shift;
            String realname;
            while (sc.hasNextLine()) {
                realname="";
                line=sc.nextLine();
                if (isReal(line)) {
                    //System.out.println(line);
                    //System.out.println(trueChecksum(frequencies(line)));
                    sum+=sectorID(line);
                    shift=sectorID(line)%26;
                    cutline=cut(line);
                    int character;
                    for (int i=0; i<cutline.length(); i++) {
                        if (cutline.charAt(i)=='-') {
                            realname+=" ";
                        }
                        else {
                            character=cutline.charAt(i)+shift;
                            if (character>'z') {
                                character-=26;
                            }
                            realname+=((char) character);
                        }
                    }
                    if (realname.equals("northpole object storage")) {
                        System.out.println(realname+" "+sectorID(line));
                    }
                }
            }
            System.out.println(sum);
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
    
}