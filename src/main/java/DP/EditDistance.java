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

    public static int editDistance(String s, String t)
    {
        return editDistanceUtil(s, 0, t, 0, new HashMap<>());
    }
}
