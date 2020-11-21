package interview;

import java.util.ArrayList;
import java.util.List;

public class PowersetSum {

    public static void main(String[] args) {

        int target = 6;
        List<String> solutions = new ArrayList<>();
        List<Integer> fibonacci = generateFib(target);
        getAllSolutions(solutions,new StringBuilder(), fibonacci, 0, target);
//        solutions.forEach(s -> s.);
        solutions.forEach(System.out::println);

    }

    private static void getAllSolutions(List<String> solutions, StringBuilder currentSol,
                                        List<Integer> fibonacci, int index, int target) {

        if (target == 0) {
            solutions.add(new String(currentSol));
            return;
        }

        if (index >= fibonacci.size()) {
            return;
        }

        //choice 1:
        //pick element
        if (target - fibonacci.get(index) >= 0) {
            //safe to pick this element
            currentSol.append('1');
            getAllSolutions(solutions, currentSol, fibonacci, index + 1, target - fibonacci.get(index));
            if (currentSol.length() > 0) {
                currentSol.deleteCharAt(currentSol.length() - 1);
            }
        }
        //ignore this element
        currentSol.append('0');
        getAllSolutions(solutions, currentSol, fibonacci, index + 1, target);
        if (currentSol.length() > 0) {
            currentSol.deleteCharAt(currentSol.length() - 1);
        }


    }

    private static List<Integer> generateFib(int target) {

        List<Integer> result = new ArrayList<>();

        if (target < 1) {
            return result;
        }

        int a1 = 1;
        int a2 = 1;

        result.add(a1);
        result.add(a2);

        int sum = a1 + a2;

        while (sum <= target) {
            result.add(sum);
            a1 = a2;
            a2 = sum;
            sum = a1 + a2;
        }
        return result;
    }
}
