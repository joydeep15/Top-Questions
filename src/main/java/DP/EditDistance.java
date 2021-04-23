package DP;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

    public static void main(String[] args) {
        System.out.println(editDistance("","bc"));
    }

    /**
     * Situation: s[i] != t[j]
     * Operations:
     * 1. Insert 1 + editDistance(s[i], t[j+1]), inserted t[j] in s
     * 2. Remove 1 + editDistance(s[i+1], t[j]), deleted s[i]
     * 3. Replace 1 + editDistance(s[i+1], t[j+1]), replaced s[i] with t[j]
     *
     * @param s
     * @param t
     * @param map storing dp results
     * @return edit distance
     */
    private static int editDistanceUtil(String s, int i, String t, int j, Map<String, Integer> map) {

        String key = i + "," + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (i == s.length() && j == t.length() ) {
            map.put(key, 0);
            return 0;
        }

        if (i >= s.length() || j >= t.length() ) {
            int val = Math.max(s.length() - i, t.length() - j);
            map.put(key, val);
            return val;
        }

        if (s.charAt(i) == t.charAt(j)) {
            int val = editDistanceUtil(s, i + 1, t, j + 1, map);
            map.put(key, val);
            return val;
        }

        int insert = 1 + editDistanceUtil(s, i, t, j + 1,map);
        int remove = 1 + editDistanceUtil(s, i + 1, t, j,map);
        int replace = 1 + editDistanceUtil(s, i + 1, t, j + 1,map);

        int val = Math.min(insert, Math.min(remove, replace));
        map.put(key, val);
        return val;
    }

    public int minDistanceDP(String word1, String word2) {

        if(word1.length() == 0){
            return word2.length();
        }else if(word2.length() == 0){
            return word1.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i <= word1.length(); i++ ){
            for(int j = 0; j <= word2.length(); j++){

                if( i == 0 && j ==0){
                    dp[i][j] = 0;
                    continue;
                }

                if(i == 0){
                    dp[i][j] = j;
                    continue;
                }

                if(j == 0){
                    dp[i][j] = i;
                    continue;
                }

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }

                int insert = 1 + dp[i][j-1];
                int delete = 1 + dp[i-1][j];
                int replace = 1 + dp[i-1][j-1];

                dp[i][j] = Math.min(insert, Math.min(delete, replace));

            }
        }
        return dp[word1.length()][word2.length()];
        // return minDistance(word1, 0, word2, 0);
    }

    public static int editDistance(String s, String t)
    {
        return editDistanceUtil(s, 0, t, 0, new HashMap<>());
    }
}
