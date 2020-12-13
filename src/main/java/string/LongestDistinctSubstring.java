package string;

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        } else if (s.length() <= 1) {
            return s.length();
        }

        Map<Character, Integer> positionMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxVal = 0;
        while (left <= right && right < s.length()) {

            maxVal = Math.max(right - left, maxVal);
            if (!positionMap.containsKey(s.charAt(right))) {
                positionMap.put(s.charAt(right), right);
                right++;
            }else {
                //dup char occurred
                //update and remove chars till left
                int maxpos = positionMap.get(s.charAt(right));
                for (int i = left; i <= maxpos; i++) {
                    positionMap.remove(s.charAt(i));
                }
                left = maxpos + 1;
                positionMap.put(s.charAt(right), right);
                right++;
            }
        }
        maxVal = Math.max(right - left, maxVal);

        return maxVal;

    }




}
