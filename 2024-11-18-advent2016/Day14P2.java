import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Day14P2 {
    public static void FiveInARowSet(int index, String hash, ArrayList<HashSet<String>> FiveInARow) {
        for (int i=0; i<hash.length()-4; i++) {
            if (hash.charAt(i)==hash.charAt(i+1) && 
            hash.charAt(i)==hash.charAt(i+2) && 
            hash.charAt(i)==hash.charAt(i+3) &&
            hash.charAt(i)==hash.charAt(i+4)) {
                FiveInARow.get(index).add(hash.substring(i, i+1));
            }
        }
    }
    public static void main(String[] args) {
        //String salt="abc";
        String salt="qzyelonm";
        ArrayList<HashSet<String>> FiveInARow = new ArrayList<HashSet<String>>();
        //set up where a character appears 5 times in a row in the first 1000 hashes
        for (int index=0; index<1000; index++) {
            FiveInARow.add(new HashSet<String>());
            FiveInARowSet(index, MD5.stretchedHash(salt+index, 2017), FiveInARow);
        }
        int index=0;
        HashSet<Integer> workingIndices = new HashSet<Integer>();
        while (workingIndices.size()<64) {
            //increases the SIZE of FiveInARow by 1
            FiveInARow.add(new HashSet<String>());
            //sets index (index+1000) of FiveInARow to be the desired HashSet
            FiveInARowSet(index+1000, MD5.stretchedHash(salt+(index+1000), 2017), FiveInARow);
            //looking for ThreeInARow of the current hash of the given index
            String hash = MD5.stretchedHash(salt+index, 2017);
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
                    if (FiveInARow.get(j).contains(ThreeInARow)) {
                        System.out.println(ThreeInARow+" "+index+" "+MD5.stretchedHash(salt+index, 2017)+" from "+j+" "+MD5.stretchedHash(salt+j, 2017)+" ");
                        workingIndices.add(index);
                    }
                }
            }
            index++;
        }
        System.out.println("");
        System.out.println("Indices where five characters appear in a row:");
        for (int i=0; i<FiveInARow.size(); i++) {
            if (FiveInARow.get(i).size()>0) {
                System.out.print(FiveInARow.get(i)+" "+i+"  ");
            }
        }
        System.out.println("");
        int ans=0;
        for (Integer n : workingIndices) {
            if (n>ans) {ans=n;}
        }
        System.out.println(ans);
        //System.out.println(workingIndices.size());
        //System.out.println(workingIndices);
    }
}