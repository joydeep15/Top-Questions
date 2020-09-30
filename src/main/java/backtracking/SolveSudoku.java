package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        char[][] solved = {
                {'5', '3', '4', '6', '7', '8', '9', '.', '.'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '.'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        solveSudoku(board);
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

    public static void solveSudoku(char[][] board) {

        if (board.length != 9) {
            return;
        }

        if (board[0].length != 9) {
            return;
        }

        if (boardComplete(board)) {
            printBoard(board);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                if (board[row][col] != '.') {
                    continue;
                }
                List<String> options = getOptions(board, row, col);
                for (String option : options) {
                    //make the choice
                    board[row][col] = option.toCharArray()[0];

                    //solve further
                    solveSudoku(board);
                }

                //undo the choice as we have exhausted all options
                // maybe its time to look into a different route?
                board[row][col] = '.';


            }
        }
    }


    private static List<String> getOptions(char[][] board, int row, int col) {

        Set<String> domain = new HashSet<String>();
        for (int i = 1; i <= 9; i++) {
            domain.add("" + i);
        }

        //remove row entries
        for (int colIter = 0; colIter < board[row].length; colIter++) {
            String element = "" + board[row][colIter];
            if (domain.contains(element)) {
                domain.remove(element);
            }
        }

        //remove col entries
        for (int rowIter = 0; rowIter < board.length; rowIter++) {
            String element = "" + board[rowIter][col];
            if (domain.contains(element)) {
                domain.remove(element);
            }
        }

        //1 indexing
        row++;
        col++;

        for (int i = Math.floorDiv(row, 3)*3 + 1; i <= Math.ceil((double) row / 3)*3; i++) {
            for (int j = Math.floorDiv(col, 3)*3 + 1; j <= Math.ceil((double) col / 3)*3; j++) {
                String element = "" + board[i - 1][j - 1];

                if (domain.contains(element)) {
                    domain.remove(element);
                }
            }
        }

        return new ArrayList<>(domain);
    }

    private static boolean boardComplete(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') {
                    return false;
                }
            }
        }

        return true;
    }

}

