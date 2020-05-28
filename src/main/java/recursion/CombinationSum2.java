package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B.
 *
 * ach number in A may only be used once in the combination.
 *
 * Note:
 *    All numbers will be positive integers.
 *    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *    The combinations themselves must be sorted in ascending order.
 *    If there is no combination possible the print "Empty" (without qoutes).
 * Example,
 * Given A = 10,1,2,7,6,1,5 and B(sum) 8,
 *
 * A solution set is:
 *
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *
 * Input:
 * First is T , no of test cases. 1<=T<=500
 * Every test case has three lines.
 * First line is N, size of array. 1<=N<=12
 * Second line contains N space seperated integers(x). 1<=x<=9.
 * Third line is the sum B. 1<=B<=30.
 *
 * Output:
 * One line per test case, every subset enclosed in () and in every set intergers should be space seperated.(See example)
 *
 * Example:
 * Input:
 * 2
 * 7
 * 10 1 2 7 6 1 5
 * 8
 * 5
 * 8 1 8 6 8
 * 12
 *
 * Output:
 * (1 1 6)(1 2 5)(1 7)(2 6)
 * Empty
 */
public class CombinationSum2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        StringBuilder sb = new StringBuilder();

        while (t != 0) {
            t--;
            int len = Integer.parseInt(bfr.readLine());
            String[] elements = bfr.readLine().split("\\s+");
            int[] blocks = new int[len];

            for (int i = 0; i < len; i++) {
                blocks[i] = Integer.parseInt(elements[i]);
            }
            int target = Integer.parseInt(bfr.readLine());
            List<List<Integer>> result = generateCombinations(blocks,target);
            if(result.size() == 0){
                sb.append("Empty\n");
                continue;
            }

            for(List<Integer> res : result){
                sb.append("(");
                for(Integer re : res){
                    sb.append(re).append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append(")");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static int sortList(List<Integer> a, List<Integer> b){

        String aa = a.toString();
        String bb = b.toString();

        return aa.compareTo(bb);
    }

    private static List<List<Integer>> generateCombinations(int[] blocks, int target) {

        Set<List<Integer>> res = new HashSet<>();

        generateCombinations(blocks, res, Collections.emptyList(), 0, target);

        List<List<Integer>> l = new ArrayList<>(res);
        res.clear();
        Comparator<List<Integer>> c = CombinationSum2::sortList;
        l.sort(c);
        return l;


    }

    private static void generateCombinations(int[] blocks, Set<List<Integer>> res, List<Integer> currentList, int idx, int target) {

        if (target == 0) {
            Collections.sort(currentList);
            res.add(currentList);
            return;
        }

        if(idx >= blocks.length || target < 0){
            currentList.clear();
            return;
        }

        List<Integer> takeList = new ArrayList<>(currentList);
        takeList.add(blocks[idx]);
        //take
        generateCombinations(blocks, res, takeList, idx + 1, target - blocks[idx]);

        //don't take
        generateCombinations(blocks, res, currentList, idx + 1, target);


    }
}
