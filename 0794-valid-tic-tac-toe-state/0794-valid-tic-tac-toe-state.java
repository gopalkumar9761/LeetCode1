class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;

        // Count number of 'X's and 'O's
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') xCount++;
                else if (c == 'O') oCount++;
            }
        }

        // Rule 1: X goes first, so X count must equal O count or be O count + 1
        if (xCount != oCount && xCount != oCount + 1) {
            return false;
        }

        boolean xWins = isWinner(board, 'X');
        boolean oWins = isWinner(board, 'O');

        // Rule 2: Both X and O cannot win at the same time
        if (xWins && oWins) {
            return false;
        }

        // Rule 3: If X wins, X must have made the last move (xCount == oCount + 1)
        if (xWins && xCount != oCount + 1) {
            return false;
        }

        // Rule 4: If O wins, O must have made the last move (xCount == oCount)
        if (oWins && xCount != oCount) {
            return false;
        }

        return true;
    }

    private boolean isWinner(String[] board, char p) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == p && board[i].charAt(1) == p && board[i].charAt(2) == p) return true;
            if (board[0].charAt(i) == p && board[1].charAt(i) == p && board[2].charAt(i) == p) return true;
        }

        // Check diagonals
        if (board[0].charAt(0) == p && board[1].charAt(1) == p && board[2].charAt(2) == p) return true;
        if (board[0].charAt(2) == p && board[1].charAt(1) == p && board[2].charAt(0) == p) return true;

        return false;
    }
}