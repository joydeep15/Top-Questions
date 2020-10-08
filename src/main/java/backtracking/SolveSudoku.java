package backtracking;

import java.util.EnumMap;

public class SolveSudoku {
//    https://leetcode.com/problems/sudoku-solver/

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] PartiallySolved = {
                { '3', '1', '6', '5', '7', '8', '4', '9', '2' },
                { '5', '2', '9', '1', '3', '4', '7', '6', '8' },
                { '4', '8', '7', '6', '2', '9', '5', '3', '1' },
                { '2', '6', '3', '.', '1', '5', '9', '8', '7' },
                { '9', '7', '4', '8', '6', '.', '1', '2', '5' },
                { '8', '5', '1', '7', '9', '2', '6', '4', '3' },
                { '1', '3', '8', '.', '4', '7', '2', '.', '6' },
                { '6', '9', '2', '3', '5', '1', '8', '7', '4' },
                { '7', '4', '5', '.', '8', '6', '3', '1', '.' }
        };

        char[][] solved = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '.', '.'},
                {'4', '2', '6', '8', '5', '3', '7', '.', '.'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        solveSudoku(solved);
        printBoard(solved);

    }

    private static void solveSudoku(char[][] board) {

        //check if board is solved
        if (isSolved(board)) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == '.') {
                    solveSudoku(board, i, j);
                }
            }
        }
    }

    private static boolean isSolved(char[][] board) {

        for (char[] row : board) {
            for (char item : row) {
                if (item == '.') {
                    return false;
                }
            }
        }
        return true;

    }

    private static void solveSudoku(char[][] board, int row, int col) {

        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)) {
                board[row][col] = (char) ('0' +  i);
                solveSudoku(board);
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col, int pos) {

        char warning = (char) ('9' - pos);

        for (int j = 0; j < board[row].length; j++) {
            if (board[row][j] == warning) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == warning) {
                return false;
            }
        }

        //check the grid

        for (int i = (row / 3) * 3; i <= (row / 3) * 3 + 2; i++) {
            for (int j = (row / 3) * 3; j <= (row / 3) * 3 + 2; j++) {

                if (board[i][j] == warning) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}

