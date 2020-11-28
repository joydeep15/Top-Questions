package string;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abc"));
    }

    public static String longestPalindrome(String s) {

        return longestCommonSubstring(s, new StringBuilder(s).reverse().toString());
    }

    private static String longestCommonSubstring(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return "";
        }

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
            }
        }
        int maxVal = 0;
        int maxi = -1;
        int maxj = -1;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (dp[i][j] > maxVal) {
                    maxVal = dp[i][j];
                    maxi = i;
                    maxj = j;
                }
            }
        }

        if (maxVal == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (dp[maxi][maxj] > 0) {
            sb.append(s1.charAt(maxi-1));
            maxi--;
            maxj--;
        }

        return sb.toString();
    }
}
