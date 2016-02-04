/**
 *Author: Satabdi Ganguly
 * Date: 28.01.2016
 * Summary: A robot is located in a 4x4 grid. The robot can move up, down, left, right.
 *          A robot cannot visit the same location twice. The code finds the number of unique ways the
 *          robot can find its way to the lower right corner of the grid.
 */

//Main Class
public class RoboMove {

    //Contains the total number of paths
    public static int paths=0;

    public static void main(String[] args) {
        //The playing field as a 4X4 Boolean Array
        boolean grid [][]= new boolean [4][4];
        grid[0][0]= true;
        start(0,1,grid);
        //Prints out the final result
        System.out.println("Number of Paths " + paths);
    }

    private  static void start(int x, int y,boolean [][]grid){
        grid[x][y]=true;
        moveUp(x,y,grid);
        moveDown(x,y,grid);
        moveLeft(x,y,grid);
        moveRight(x,y,grid);
    }

    private static void moveUp(int x, int y, boolean [][] grid){
        if(x==0) return;
        else{
            if (grid[x-1][y]) return;
            grid[x-1][y]=true;
            start(x-1,y,grid);
            grid[x-1][y]=false;
        }
    }

    private static void moveDown(int x, int y, boolean [][] grid){
        if(x==3 && y==3){
            paths++;
            grid[x][y]=true;
            return;
        }
        else if(x==3) return;
        else{
            if (grid[x+1][y]) return;
            grid[x+1][y]=true;
            start(x+1,y,grid);
            grid[x+1][y]=false;
        }
    }
    private static void moveLeft(int x, int y, boolean [][] grid){
        if(y==0) return;
        else{
            if (grid[x][y-1]) return;
            grid[x][y-1]=true;
            start(x,y-1,grid);
            grid[x][y-1]=false;
        }
    }

    private static void moveRight(int x, int y, boolean [][] grid){
        if(x==3 && y==3){
            paths++;
            grid[x][y]=true;
            return;
        }else if(y==3) return;
        else{
            if (grid[x][y+1]) return;
            grid[x][y+1]=true;
            start(x,y+1,grid);
            grid[x][y+1]=false;
        }
    }

}
