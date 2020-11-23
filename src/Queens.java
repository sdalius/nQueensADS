import java.util.Arrays;

class Queens {
    private int solutions;
    private int[][] board;

    Queens(int boardSize)
    {
        /* Board size has always be bigger than 3 */
        if (!(boardSize > 3))
        {
            System.out.println("n must be bigger than 3. Quitting...");
            System.exit(1);
        }
        else{
            /* Initialize the board, initialize the solutions variable, and start solving the board */
            board = new int[boardSize][boardSize];
            solutions = 0;
            // Enter the start of the column.
            getSolutionOfTheBoard(0);
        }
    }

    /* Everytime we print board, that means it was a solution, so solution everytime increments if the printboard was called */
    private void printBoard()
    {
        solutions++;
        System.out.println("We have : "  + solutions + " solutions so far" );

        /* Print all rows */
        for (int[] row : board)
            System.out.println(Arrays.toString(row));
        System.out.println("===========================================================");
    }

    private boolean isOkToPlaceQueen(int row, int col)
    {
        int i, j;
        /* Check the row */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check crosswise  */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check crosswise in reverse */
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    private boolean getSolutionOfTheBoard(int col)
    {
        if (board.length == col)
        {
            printBoard();
            return true;
        }
        // Try to place queens in all rows of the column , one by one
        boolean success = false;
        for (int i = 0; i < board.length; i++) {
            if(isOkToPlaceQueen(i, col)) {
                board[i][col] = 1;

                success = getSolutionOfTheBoard(col + 1);
                board[i][col] = 0;
            }
        }
        return success;
    }
}
