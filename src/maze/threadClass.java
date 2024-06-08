package maze;

public class threadClass {
    static int [][] maze;
    static int n;
    int [][] sol;
    int row, col;
   
    public threadClass(int [][]maze ,int N,int row, int col ,int [][] sol) {
        threadClass.maze=maze;
        this.sol = sol;
        this.row = row;
        this.col = col;
        RatMaze rat = new RatMaze(threadClass.maze,N,this.sol,this.row,this.col);
        Thread t = new Thread(rat);
        t.start();
        
    }

    
}
