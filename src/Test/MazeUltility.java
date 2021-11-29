package Test;

public class MazeUltility {
    public static void displayMaze(char[][]maze) {
        for (int i = 0; i < maze.length; i ++) {
            for (int j = 0; j < maze[i].length; j ++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public static int countEnd(char[][]maze) {
        int count = 0;
        for(int i = 0; i< maze.length; i ++) {
            for(int j = 0; j < maze[i].length; j ++) {
                if(maze[i][j] == 'E') count ++;
            }
        }
        return count;
    }

    private static boolean traverse(int r, int c, char[][] maze, boolean [][] visited) {
        if(maze[r][c] == 'E') {
            return true;
        }
        visited[r][c] = true;
        boolean res = false;
        int[] rowDir = {0,0,-1,1};
        int[] colDir = {1,-1,0,0};

        for(int i = 0; i < rowDir.length; i ++) {
            int newRow = r + rowDir[i];
            int newCol = c + colDir[i];
            if(newRow >= 0 && newRow < maze.length &&
            newCol >= 0 && newCol < maze[0].length && maze[newRow][newCol] != '*' && !visited[newRow][newCol]) {
                res = res || traverse(newRow, newCol, maze, visited);
            }
        }
        return res;
    }

    public static  boolean solvable (char[][]maze) {
        int r = maze.length;
        int c = maze[0].length;

        //Find the start location
        int startR = 0, startC = 0;
        for(int i = 0; i < r; i ++) {
            for(int j = 0; j < c; j ++) {
                if(maze[i][j] == 'S') {
                    startR =i;
                    startC = j;
                    break;
                }
            }
        }

        //Maintain visited cells
        boolean [][] visited = new boolean[r][c];
        for(int i = 0; i < r; i ++) {
            for (int j = 0; j < c ; j ++) {
                visited[i][j] = false;
            }
        }
        boolean res = traverse(startR,startC,maze,visited);
        return res;
    }
    public static void main(String[] args) {
        // not solvable
        char[][] maze1 = {
                {'.', '.', '.', '.'},
                {'*', 'S', '*', '*'},
                {'.', '*', '.', 'E'},
        };

        displayMaze(maze1);
        System.out.println(countEnd(maze1));
        System.out.println(solvable(maze1));

        // solvable
        char[][] maze2 = {
                {'S', '.', '*', '.'},
                {'*', '.', '*', '*'},
                {'E', '.', '*', 'E'},
        };

        displayMaze(maze2);
        System.out.println(countEnd(maze2));
        System.out.println(solvable(maze2));
    }
}
