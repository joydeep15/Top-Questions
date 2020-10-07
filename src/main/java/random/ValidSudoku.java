package random;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] board = {

                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}

        };

        System.out.println(isValidSudoku(board));


    }

    static void populateDomain(Set<Integer> domain){

        domain.clear();
        for(int i = 1 ; i<= 9; i++){
            domain.add(i);
        }
    }


    public static boolean isValidSudoku(char[][] board) {

        Set<Integer> domain = new HashSet<>();
        populateDomain(domain);

        for(int i=0; i < board.length; i++ ){
            populateDomain(domain);
            for(int j=0; j < board[i].length; j++){

                if(board[i][j]=='.')
                    continue;
                int element = Integer.parseInt("" + board[i][j]);
                if(domain.contains(element)){
                    domain.remove(element);
                }else{
                    return false;
                }
            }
        }

        for(int i=0; i < board.length; i++ ){
            populateDomain(domain);
            for(int j=0; j < board[i].length; j++){

                if(board[j][i]=='.')
                    continue;
                int element = Integer.parseInt("" + board[j][i]);
                if(domain.contains(element)){
                    domain.remove(element);
                }else{
                    return false;
                }
            }
        }

        boolean gridValid = true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                gridValid = gridValid && validateGrid(board, i*3, j*3);
                if(!gridValid){
                    return false;
                }
            }
        }

        return true;
    }

    static boolean validateGrid(char[][] board, int rowStart, int colStart){


        Set<Integer> domain = new HashSet<Integer>();
        populateDomain(domain);

        for(int i = rowStart; i<= rowStart + 2; i++){
            for(int j=colStart; j<= colStart + 2; j++){

                if(board[i][j]=='.')
                    continue;
                int element = Integer.parseInt("" + board[i][j]);
                if(domain.contains(element)){
                    domain.remove(element);
                }else{
                    return false;
                }
            }
        }

        return true;
    }


}
