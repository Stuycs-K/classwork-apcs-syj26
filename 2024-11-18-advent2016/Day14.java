import java.util.HashSet;
import java.util.ArrayList;

public class Day14 {
    public static void main(String[] args) {
        ArrayList<HashSet<String>> FiveInARow = new ArrayList<HashSet<String>>();
        for (int index=0; index<10000; index++) {
            String hash = MD5.hash("qzyelonm", index);
            for (int i=0; i<hash.length()-4; i++) {
                FiveInARow.add(new HashSet<String>());
                if (hash.charAt(i)==hash.charAt(i+1) && 
                hash.charAt(i)==hash.charAt(i+2) && 
                hash.charAt(i)==hash.charAt(i+3) &&
                hash.charAt(i)==hash.charAt(i+4)) {
                    FiveInARow.get(index).add(hash.substring(i, i+1));
                }
            }
        }
        for (int i=0; i<10000; i++) {
            if (FiveInARow.get(i).size()>0) {
                System.out.println(FiveInARow.get(i)+" "+i);
            }
        }
        /*
         int index=0;
        int count=0;
        int[] workingIndices = new int[64];
        while (count<64) {
            String hash = MD5.hash("qzyelonm", index);
            HashSet<Integer> ThreeInARow = new ArrayList<Integer>();
            for (int i=0; i<hash.length()-2; i++) {
                if (hash.charAt(i)==hash.charAt(i+1) && hash.charAt(i)==hash.charAt(i+2)) {
                    ThreeInARow.add(i);
                }
            }

        }
         */
        
    }
}