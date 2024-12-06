import java.util.ArrayList;
public class Day19 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(3004953);
        for (int i=0; i<3004953; i++) {arr.add(i+1);}
        System.out.println("initialized");
        int i=0; 
        while (arr.size()>1) {
            //System.out.println(arr);
            int rm=(i+arr.size()/2)%arr.size();
            boolean shift=rm<i%arr.size();
            arr.remove(rm);
            if (!shift) {
                i=(i+1)%arr.size();
            } else {
                i%=arr.size();
            }
            //just so i can see how fast it's running
            if (arr.size()%10000==0) {
                System.out.println(arr.size());
            }
        }
        System.out.println(arr);
    }
}