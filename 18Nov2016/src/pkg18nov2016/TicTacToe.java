package pkg18nov2016;

import java.util.Arrays;

/**
 *
 * @author NTHock
 */
public class TicTacToe {
    private String[][] grid;
    
    /**
    This constructor will create a 3x3 grid for
    playing TicTacToe
    */
    public TicTacToe()
    {
        grid = new String[3][3];
        
        for (int row = 0; row < grid.length; row++)
        {
            Arrays.fill(grid[row], " ");
            
        }
    }
    public static void main(String []args)
    {
        TicTacToe myPuzzle = new TicTacToe();
        myPuzzle.makeMove(1, 1, "X"); //grid[1][1]="X";
        
        //this should cause an exception
        try
        {
            myPuzzle.makeMove(3, 2, "O");
        }
        catch (IllegalArgumentException exception)
        {
            System.out.println(exception.getMessage());
        }
        myPuzzle.grid[1][2]="O";
        myPuzzle.grid[2][2]="X";
        myPuzzle.grid[0][0]="O";
        myPuzzle.grid[2][0]="X";
        myPuzzle.grid[0][2]="O";
        myPuzzle.grid[0][1]="X";
        myPuzzle.grid[2][1]="O";
        myPuzzle.grid[1][0]="X";
        myPuzzle.displayGrid();
        
    }//end of main method
    
    /**
     * This method will receive a row, a col and the player
     * info (X or O). It will validate if the position is available
     * and set the player on the position if it is available
     */
    public void makeMove(int row, int col, String player)
    {
        if (row < 0 || row > 2)
            throw new IllegalArgumentException("Row must be 0-2.");
        
        if (col < 0 || row > 2)
            throw new IllegalArgumentException("Column must be 0-2");
        
        if (grid[row][col].equals(" "))
            grid[row][col]=player;
        else
            throw new IllegalArgumentException("["+row+"]["+col+"] is already taken.");
    }
    /**
    This method will display the game board
    */
    public void displayGrid()
    {
        for (int row = 0; row < grid.length; row++)
        {
            for (int col =0; col <grid.length; col++)
            {
                if (col==2)
                    System.out.printf(" %s ", grid[row][col]);
                else
                    System.out.printf(" %s |", grid[row][col]);
            }//end of column for loop
            if (row==2)
                System.out.println();
            else
                System.out.println("\n-----------");
        }   //end of column for loop
    }//end of displayGrid() method
}
