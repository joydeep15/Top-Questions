package DP;

import utilities.BReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstring {

    public static void main(String[] args) throws IOException {

        int t = BReader.getInteger();
        while (t != 0) {
            t--;
            int[] lens = BReader.getIntegerArray("\\s+");
            String a = BReader.getString();
            String b = BReader.getString();
//            System.out.println(lcsRecursive(a, b, a.length() - 1, b.length() - 1,0, new HashMap<>()));
            System.out.println(lcsIterative(a, b));
        }


    }

    private static int lcsRecursive(String a, String b, int m, int n, int sol, Map<String, Integer> solutions) {

        if (solutions.containsKey(m + "," + n)) {
            return solutions.get(m + "," + n);
        }

        if (m == -1 || n == -1) {
            solutions.put(m + "," + n, sol);
            return sol;
        }


        if (a.charAt(m) == b.charAt(n)) {
            sol =  lcsRecursive(a, b, m - 1, n - 1,sol+1, solutions);

        }
        sol =  Math.max(sol,Math.max(lcsRecursive(a, b, m, n - 1, 0,solutions), lcsRecursive(a, b, m - 1, n,0, solutions)));
        solutions.put(m + "," + n, sol);
        return sol;

    }

    private static int lcsIterative(String a, String b) {

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

            }
        }

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
