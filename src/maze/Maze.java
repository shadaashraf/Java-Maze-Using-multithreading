package maze;

import java.util.*;

public class Maze {

    static int N;
    static public int[][] generateGrid(int n) {
        int[][] array = new int[n][n];
        Random r = new Random();
        int i , j;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0 && j == 0 || i == n - 1 && j == n - 1) {
                    int m = array[i][j] = 1;
                    System.out.print(m + " ");
                } else {
                    int m = array[i][j] = r.nextInt(2);
                    System.out.print(m + " ");
                }
            }
            System.out.println();
        }
        return array;
    }

    public static void main(String args[]) {

        int [][] sol = {{0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0}};
        int n =4;
        int maze[][] = {{1,1,1,1},
                        {1,1,0,1},
                        {1,1,0,1},
                        {1,1,1,1}};
        N = maze.length;
        System.out.println(N);
        new threadClass(maze,n,0,0,sol);
    }

}

