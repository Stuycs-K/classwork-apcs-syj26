import java.util.*;
import java.io.*;

public class Day10 {
    public static void main(String[] args) {
        ArrayList<String> going = new ArrayList<String>(1);
        ArrayList<String> giving = new ArrayList<String>(1);
        ArrayList<ArrayList<Integer>> bots = new ArrayList<ArrayList<Integer>>(210);
        int[] output=new int[210];
        for (int i=0; i<210; i++) {
            ArrayList<Integer> a = new ArrayList<Integer>(6);
            a.add(-1); a.add(-1); a.add(-1); a.add(-1);
            bots.add(a);
        }
        try {
            Scanner sc = new Scanner(new File("2016d10.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.charAt(0)=='b') {
                    giving.add(line);
                }
                if (line.charAt(0)=='v') {
                    going.add(line);
                }
            }
            for (int i=0; i<going.size(); i++) {
                String line=going.get(i);
                int value, bot;
                line=line.substring(line.indexOf(" ")+1);
                value=Integer.parseInt(line.substring(0, line.indexOf(" ")));
                bot=Integer.parseInt(line.substring(line.indexOf("bot")+4));
                bots.get(bot).add(value);
            }
            for (int i=0; i<giving.size(); i++) {
                String line=giving.get(i);
                int giver, low, high;
                line=line.substring(line.indexOf(" ")+1);
                giver=Integer.parseInt(line.substring(0, line.indexOf(" ")));
                if (line.indexOf("low to bot")>=0) {
                    bots.get(giver).set(0, Integer.valueOf(1));
                    bots.get(giver).set(2, Integer.parseInt(line.substring(line.indexOf("bot")+4, line.indexOf(" and"))));
                } else {
                    bots.get(giver).set(0, Integer.valueOf(0));
                    bots.get(giver).set(2, Integer.parseInt(line.substring(line.indexOf("output")+7, line.indexOf(" and"))));
                }
                line=line.substring(line.indexOf("and"));
                if (line.indexOf("high to bot")>=0) {
                    bots.get(giver).set(1, Integer.valueOf(1));
                    bots.get(giver).set(3, Integer.parseInt(line.substring(line.indexOf("bot")+4)));
                } else {
                    bots.get(giver).set(1, Integer.valueOf(0));
                    bots.get(giver).set(3, Integer.parseInt(line.substring(line.indexOf("output")+7)));
                }
                /* 
                System.out.println(Arrays.toString(bots[giver]));
                if (Math.min(bots[giver][0], bots[giver][1])==17 && Math.max(bots[giver][0], bots[giver][1])==61) {
                    System.out.println(giver);
                }
                if (bots[giver][0]>0 && bots[giver][1]>0) {
                    if (low>=0) {
                        if (bots[low][0]==0) {
                            bots[low][0]=Math.min(bots[giver][0], bots[giver][1]);
                        } else {
                            bots[low][1]=Math.min(bots[giver][0], bots[giver][1]);
                        }
                    }
                    if (high>=0) {
                        if (bots[high][0]==0) {
                            bots[high][0]=Math.max(bots[giver][0], bots[giver][1]);
                        } else {
                            bots[high][1]=Math.max(bots[giver][0], bots[giver][1]);
                        }
                    }
                }
                bots[giver]=new int[2];
                */
            }
            boolean done=false;
            while (!done) {
                int maxSize=0;
                for (int i=0; i<bots.size(); i++) {
                    if (bots.get(i).size()==6) {
                        maxSize=6;
                        int low; int high;
                        low=Math.min(bots.get(i).get(4), bots.get(i).get(5));
                        high=Math.max(bots.get(i).get(4), bots.get(i).get(5));
                        if (low==17 && high==61) {
                            System.out.println("index of bot comparing 17 and 61: "+i);
                        }
                        //transfering values
                        if (bots.get(i).get(0)==0) {
                            output[bots.get(i).get(2)]=low;
                        } else {
                            bots.get(bots.get(i).get(2)).add(low);
                        }
                        if (bots.get(i).get(1)==0) {
                            output[bots.get(i).get(3)]=high;
                        } else {
                            bots.get(bots.get(i).get(3)).add(high);
                        }
                        //get rid of values
                        bots.get(i).remove(5);
                        bots.get(i).remove(4);
                    }
                }
                if (maxSize!=6) {done=true;}
            }
            System.out.println("products of chips in outputs 0, 1, 2: "+output[0]*output[1]*output[2]);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}