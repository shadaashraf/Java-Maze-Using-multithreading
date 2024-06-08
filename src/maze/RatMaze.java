package maze;

public class RatMaze implements Runnable {

    static int N;
    static int maze[][];
    int sol[][];
    int row;
    int col;

    public RatMaze(int Maze[][], int n,int sol[][],int row,int col) {
        maze = Maze;
        N = n;
        this.sol = sol;
        this.row = row;
        this.col = col;

    }

    static void Solution(int[][] soll) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(soll[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int maze[][], int row, int col) {
        return (row >= 0 && row < N && col >= 0 && col < N && maze[row][col] == 1);
    }

    static boolean solve(int maze[][],int soll[][] , int row, int col) {
     //   int sol[][] = new int[N][N];

        if (solveMaze(maze, row, col, soll) == false) {
            System.out.println("Solution doesn't exist");
            return false;
        }

        Solution(soll);
        return true;
    }

    static boolean solveMaze(int maze[][], int row, int col, int soll[][]) {
        if (row == N - 1 && col == N - 1
                && maze[row][col] == 1) {
            soll[row][col] = 1;
            return true;
        }
        if (isSafe(maze, row, col) == true) {
            if (soll[row][col] == 1) {
                return false;
            }
            soll[row][col] = 1;
            if (isSafe(maze, row + 1, col) && isSafe(maze, row, col + 1)) {
                new threadClass(maze, N, row+1, col, soll);
                if (solveMaze(maze, row , col+1, soll)) {
                return true;
                }
            }
            if (solveMaze(maze, row + 1, col, soll)) {
                return true;
            }
            if (solveMaze(maze, row, col + 1, soll)) {
                return true;
            }
            soll[row][col] = 0;
            return false;
        }
        return false;
    }

    @Override
    public void run() {
        solve(maze,sol,row,col);

    }

}
