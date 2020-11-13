package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(lcsIterative("ABC", "AC"));

    }

    static int lcsRecursive(int p, int q, String s1, String s2, Map<String, Integer> map){

        String key = p + "," + q;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (p == 0 || q == 0) {
            map.put(key, 0);
            return map.get(key);
        }
        if (s1.charAt(p - 1) == s2.charAt(q - 1)) {
            map.put(key, 1 + lcsRecursive(p - 1, q - 1, s1, s2, map));
        }else {
            map.put(key, Math.max(lcsRecursive(p - 1, q, s1, s2, map), lcsRecursive(p, q - 1, s1, s2, map)));
        }
        return map.get(key);
    }

    static int lcsIterative(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

}
