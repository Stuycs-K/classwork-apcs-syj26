public class Day18 {
    public static void main(String[] args) {
        String[] maze=new String[400000];
        maze[0]=".^^^^^.^^.^^^.^...^..^^.^.^..^^^^^^^^^^..^...^^.^..^^^^..^^^^...^.^.^^^^^^^^....^..^^^^^^.^^^.^^^.^^";
        for (int i=1; i<maze.length; i++) {
            maze[i]="";
            if (maze[i-1].charAt(1)=='^') {maze[i]+="^";}
            else {maze[i]+=".";}
            for (int j=1; j<maze[i-1].length()-1; j++) {
                String s=maze[i-1].substring(j-1, j+2);
                if (s.equals("^^.") || s.equals(".^^") || s.equals("^..") || s.equals("..^")) {
                    maze[i]+="^";
                } else {
                    maze[i]+=".";
                }
            }
            if (maze[i-1].charAt(maze[i-1].length()-2)=='^') {maze[i]+="^";}
            else {maze[i]+=".";}
        }
        int count=0;
        for (int i=0; i<maze.length; i++) {
            for (int j=0; j<maze[i].length(); j++) {
                if (maze[i].charAt(j)=='.') {count++;}
            }
        }
        System.out.println(count);
    }
}