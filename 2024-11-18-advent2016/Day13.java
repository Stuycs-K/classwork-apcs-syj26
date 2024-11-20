public class Day13 {
    public static boolean isWall(int x, int y) {
        int num = 1352+x*x+3*x+2*x*y+y+y*y;
        int ans=countOnes(binarify(num));
        if (ans%2==0) {return false;}
        return true;
    }
    public static int[] binarify(int n) {
        int[] ans=new int[16];
        for (int i=15; i>=0; i--) {
            ans[i]=n%2;
            n/=2;
        }
        return ans;
    }
    public static int countOnes(int[] nums) {
        int count=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==1) {count++;}
        }
        return count;
    }
    public static void main(String[] args) {
        boolean[][] maze=new boolean[50][40];
        for (int i=0; i<maze.length; i++) {
            for (int j=0; j<maze[0].length; j++) {
                maze[i][j]=isWall(j, i);
            }
        }
        for (int i=0; i<maze.length; i++) {
            for (int j=0; j<maze[0].length; j++) {
                if ((i==1 && j==1) || (i==39 && j==31)) {
                    System.out.print("o");
                } else {
                    if (maze[i][j]==false) {
                        System.out.print(".");
                    }
                    if (maze[i][j]==true) {
                        System.out.print("#");
                    }
                }
            }
            System.out.println("");
        }
    }
}