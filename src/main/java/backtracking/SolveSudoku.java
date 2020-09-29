package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveSudoku {
//    https://leetcode.com/problems/sudoku-solver/

    public void solveSudoku(char[][] board) {

        if (board.length != 9) {
            return;
        }

        if (board[0].length != 9) {
            return;
        }

        if (boardComplete(board)) {
            return;
        }

        for (int row = 0; row <= board.length; row++) {
            for (int col = 0; col <= board[row].length; col++) {

                if (board[row][col] != '.') {
                    continue;
                }
                List<String> options = getOptions(board, row, col);
                for (String option : options) {
                    //make the choice
                    board[row][col] = option.toCharArray()[0];

                    //validate the choice
                }


            }
        }
    }

    private List<String> getOptions(char[][] board, int row, int col) {

        Set<String> domain = new HashSet<String>();
        for (int i = 1; i <= 9; i++) {
            domain.add("" + i);
        }

        //remove row entries
        for (int colIter = 0; colIter <= board[row].length; colIter++) {
            String element = "" + board[row][colIter];
            if (domain.contains(element)) {
                domain.remove(element);
            }
        }

        //remove col entries
        for (int rowIter = 0; rowIter <= board.length; rowIter++) {
            String element = "" + board[rowIter][col];
            if (domain.contains(element)) {
                domain.remove(element);
            }
        }
        return new ArrayList<>(domain);
    }

    private boolean boardComplete(char[][] board) {

        for (int row = 0; row <= board.length; row++) {
            for (int col = 0; col <= board[row].length; col++) {
                if (board[row][col] == '.') {
                    return false;
                }
            }
        }

        return true;
    }

}

