package string;

import java.util.Map;

public class MakePalindrome {

    public static int minInsertions(String s) {


        if (s == null || s.length() == 0) {
            return 0;
        }

        int lcs_length = getLcs(s, new StringBuilder(s).reverse().toString());
        return s.length() - lcs_length;
    }

    private static int getLcs(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
