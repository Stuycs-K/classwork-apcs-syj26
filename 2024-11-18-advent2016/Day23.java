import java.util.*;
import java.io.*;

public class Day23 {
    public static int foo(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception ex) {
            return s.charAt(0)-'a';
        }
    }
    //modified "multiplying" command
    public static void copy(int[] abcd, String x, int y) {
        try {
            abcd[y]=Integer.parseInt(x);
        } catch (Exception ex) {
            abcd[y]=abcd[foo(x)];
        }
    }
    public static int[] jnz(int[] abcd, String x, String y) {
        int[] nums=new int[2];
        try {
            nums[0]=Integer.parseInt(x);
        } catch (Exception ex) {
            nums[0]=abcd[foo(x)];
        }
        try {
            nums[1]=Integer.parseInt(y);
        } catch (Exception ex) {
            nums[1]=abcd[foo(y)];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] abcd=new int[4];
        //make a be 7
        abcd[0]=7;
        try {
            Scanner sc = new Scanner(new File("2016d23.txt"));
            ArrayList<String[]> commands = new ArrayList<String[]>(1);
            while (sc.hasNextLine()) {
                commands.add(sc.nextLine().split(" "));
            }
            //prints array
            System.out.print("[");
            for (int i=0; i<commands.size(); i++) {
                System.out.print(Arrays.toString(commands.get(i)));
                if (i<commands.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            //actual code
            boolean done=false;
            int i=0;
            while (!done) {
                try {
                    if (commands.get(i)[0].equals("jnz") && jnz(abcd, commands.get(i)[1], commands.get(i)[2])[0]!=0) {
                        try {
                            i+=jnz(abcd, commands.get(i)[1], commands.get(i)[2])[1];
                        } catch (Exception ex) {}
                        
                    } else {
                        if (commands.get(i)[0].equals("cpy")) {
                            try {
                                copy(abcd, commands.get(i)[1], foo(commands.get(i)[2]));
                            } catch (Exception ex) {}
                        }
                        if (commands.get(i)[0].equals("inc")) {
                            abcd[foo(commands.get(i)[1])]++;
                        }
                        if (commands.get(i)[0].equals("dec")) {
                            abcd[foo(commands.get(i)[1])]--;
                        }
                        if (commands.get(i)[0].equals("tgl")) {
                            int x = abcd[foo(commands.get(i)[1])];
                            try {
                                System.out.print("\u001b[1;4;"+101+";"+"38;2;82;6;6"+"m"+x+" "+Arrays.toString(abcd)+"\u001b[0m");
                                if (commands.get(i+x).length==2) {
                                    if (commands.get(i+x)[0].equals("inc")) {
                                        commands.get(i+x)[0]="dec";
                                    } else {
                                        commands.get(i+x)[0]="inc";
                                    }
                                }
                                if (commands.get(i+x).length==3) {
                                    if (commands.get(i+x)[0].equals("jnz")) {
                                        commands.get(i+x)[0]="cpy";
                                    } else {
                                        commands.get(i+x)[0]="jnz";
                                    }
                                }
                            } catch (Exception ex) {}
                        }
                        System.out.print(Arrays.toString(commands.get(i))+" ");
                        System.out.println(Arrays.toString(abcd));
                        i++;
                        System.out.println(i+" "+commands.size());
                        //if (abcd[3]>1000) {done=true;} //FOR TESTING PURPOSES ONLY
                    }
                } catch (IndexOutOfBoundsException ex) {
                    done=true;
                }
            }
            System.out.println(Arrays.toString(abcd));
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
        
    }
}