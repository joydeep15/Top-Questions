package backtracking;

import java.util.*;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        solveNQueens(n, 0,new ArrayList<String>(), result);

        List<List<String>> translatedRes = translate(result);
        return translatedRes;
    }

    private List<List<String>> translate(List<List<String>> items) {

        List<List<String>> allResults = new ArrayList<>();

        for (List<String> item : items) {
            List<String> solution = new ArrayList<>();
            for (String pos : item) {
                StringBuilder sb = new StringBuilder();
                int n = item.size();
                int position = Integer.parseInt(pos);
                for (int i = 0; i < n; i++) {
                    if (i == position) {
                        sb.append("Q");
                    } else sb.append(".");
                }
                solution.add(sb.toString());
            }
            allResults.add(solution);
        }

        return allResults;
    }

    private void solveNQueens(int n, int row, List<String> currentQ, List<List<String>> result) {

        //GOAL and base case
        if (currentQ.size() == n && row == n) {
            result.add(new ArrayList<>(currentQ));
            return;
        }


        for (int column = 0; column < n; column++) {

            //Make a choice
            currentQ.add(""+column);

            //is the choice correct?
            if (isValidPlacement(currentQ, n)) {
                //proceed to make the next choice
                solveNQueens(n, row+1, currentQ,result);
            }

            //undo the choice as either one successful run finished or
            // the previous choice was wrong
            currentQ.remove(currentQ.size() - 1);
        }
    }

    public boolean isValidPlacement(List<String> queens, int n) {

        if (queens.size() == 1) {
            return true;
        }

        //size two now

        //check verticals
        Set<String> queenset = new HashSet<>();
        for (String queen : queens) {
            if (queenset.contains(queen)) {
                return false;
            }
            queenset.add(queen);
        }

        queenset.clear();

//        right diagonal
        for (int i = 0; i < queens.size(); i++) {

            int comparQ = Integer.parseInt(queens.get(i));
            int attackingPos = comparQ + 1;
            for (int j = i+1; j < queens.size(); j++) {
                int currentQ = Integer.parseInt(queens.get(j));
                if (attackingPos == currentQ) {
                    return false;
                }
                attackingPos += 1;
            }
        }

//        left diagonal
        for (int i = 0; i < queens.size(); i++) {
            int comparQ = Integer.parseInt(queens.get(i));
            int attackingPos = comparQ - 1;
            for (int j = i + 1; j < queens.size() ; j++) {
                int currentQ = Integer.parseInt(queens.get(j));
                if (attackingPos == currentQ) {
                    return false;
                }
                attackingPos -= 1;
            }
        }

        return true;
    }

}
