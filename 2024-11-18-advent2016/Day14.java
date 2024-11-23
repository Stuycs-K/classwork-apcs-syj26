import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Day14 {
    public static void FiveInARowSet(int index, String hash, ArrayList<String> FiveInARow) {
        boolean done=false;
        for (int i=0; i<hash.length()-4; i++) {
            if (!done && hash.charAt(i)==hash.charAt(i+1) && 
            hash.charAt(i)==hash.charAt(i+2) && 
            hash.charAt(i)==hash.charAt(i+3) &&
            hash.charAt(i)==hash.charAt(i+4)) {
                FiveInARow.set(index, hash.substring(i, i+1));
                done=true;
            }
        }
    }
    public static void main(String[] args) {
        String salt="abc";
        ArrayList<String> FiveInARow = new ArrayList<String>();
        //set up where a character appears 5 times in a row in the first 1000 hashes
        for (int index=0; index<1000; index++) {
            FiveInARow.add(null);
            FiveInARowSet(index, MD5.hash(salt, index), FiveInARow);
        }

        int index=0;
        HashSet<Integer> workingIndices = new HashSet<Integer>();
        while (workingIndices.size()<=64) {
            //increases the SIZE of FiveInARow by 1
            FiveInARow.add(null);
            //sets index (index+1000) of FiveInARow to be the desired HashSet
            FiveInARowSet(index+1000, MD5.hash(salt, index+1000), FiveInARow);
            //looking for ThreeInARow of the current hash of the given index
            String hash = MD5.hash(salt, index);
            String ThreeInARow = null;
            boolean triple=false;
            //find where a character appears 3 in a row
            for (int i=0; i<hash.length()-2; i++) {
                if (hash.charAt(i)==hash.charAt(i+1) && hash.charAt(i)==hash.charAt(i+2) && !triple) {
                    ThreeInARow=hash.substring(i, i+1);
                    triple=true;
                }
            }
            //adds index to working indices if an element of ThreeInARow is in FiveInARow from index (index+1) to (index+1000)
            if (ThreeInARow != null) {
                for (int j=index+1; j<=index+1000; j++) {
                    if (FiveInARow.get(j)!=null && FiveInARow.get(j).equals(ThreeInARow)) {
                        System.out.println(ThreeInARow+" "+index+" "+MD5.hash(salt, index)+" from "+j+" "+MD5.hash(salt, j)+" ");
                        workingIndices.add(index);
                    }
                }
            }
            index++;
        }
        System.out.println("");
        for (int i=0; i<FiveInARow.size(); i++) {
            if (FiveInARow.get(i) != null) {
                System.out.println(FiveInARow.get(i)+" "+i+" "+MD5.hash(salt, i));
            }
        }
        int ans=0;
        for (Integer n : workingIndices) {
            if (n>ans) {ans=n;}
        }
        System.out.println(ans);
        System.out.println(workingIndices.size());
        System.out.println(workingIndices);
    }
}