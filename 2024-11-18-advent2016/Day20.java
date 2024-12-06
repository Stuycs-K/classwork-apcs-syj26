import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day20 {
    public static ArrayList<Long[]> sort(ArrayList<Long[]> arr) {
        ArrayList<Long[]> ans = new ArrayList<Long[]>(arr.size());
        while (arr.size()>0) {
            int minIndex=0;
            long min=arr.get(0)[0];
            for (int i=1; i<arr.size(); i++) {
                if (arr.get(i)[0]<min) {
                    min=arr.get(i)[0];
                    minIndex=i;
                }
            }
            ans.add(arr.get(minIndex));
            arr.remove(minIndex);
        }
        return ans;
    }

    public static ArrayList<Long[]> combine(ArrayList<Long[]> arr) {
        int i=0;
        while (i<arr.size()-1) {
            if (arr.get(i+1)[0]<=arr.get(i)[1]+1) {
                arr.set(i, new Long[]{arr.get(i)[0], Math.max(arr.get(i+1)[1], arr.get(i)[1])});
                arr.remove(i+1);
            } else {
                i++;
            }
        }
        return arr;
    }

    public static boolean inRange(long n, Long[] interval) {
        return (n>=interval[0] && n<=interval[1]);
    }

    public static boolean inRange(long n, ArrayList<Long[]> ranges) {
        for (int i=0; i<ranges.size()-1; i++) {
            if (inRange(n, ranges.get(i))) {
                return true;
            }
            if (n>ranges.get(i)[1] && n<ranges.get(i+1)[0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(new File("2016d20.txt"));
            ArrayList<String> input = new ArrayList<String>();
            while (sc.hasNext()) {
                input.add(sc.next());
            }
            ArrayList<Long[]> ranges = new ArrayList<Long[]>();
            for (int i=0; i<input.size(); i++) {
                ranges.add(new Long[]{Long.parseLong(input.get(i).substring(0, input.get(i).indexOf("-"))), Long.parseLong(input.get(i).substring(input.get(i).indexOf("-")+1))});
            }
            ranges=sort(ranges);
            /* 
            for (int i=0; i<ranges.size(); i++) {
                System.out.print(Arrays.toString(ranges.get(i))+", ");
            }
            long ans=0L; boolean done=false;
            while (!done) {
                if (inRange(ans, ranges)) {
                    ans++;
                } else {
                    done=true;
                }
            }
            */
            ranges=combine(ranges);
            for (int i=0; i<ranges.size(); i++) {
                System.out.print(Arrays.toString(ranges.get(i))+", ");
            }
            long ans=4294967296L;
            for (int i=0; i<ranges.size(); i++) {
                ans-=(ranges.get(i)[1]-ranges.get(i)[0]+1);
            }
            System.out.println("\n answer: "+ans);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}