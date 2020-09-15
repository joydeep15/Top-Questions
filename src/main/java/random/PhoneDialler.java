package random;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PhoneDialler {
//    https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
    public static void main(String[] args) {
        List<String> x = letterCombinations("23");
        x.forEach(System.out::println);
    }
    public static List<String> letterCombinations(String digits) {

        String[] arr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();

        if(digits.contains("1") || digits.contains("0"))
            return Collections.emptyList();

        int totalPerms = 1;

        for(char c : digits.toCharArray()){
            totalPerms *= arr[c - '0' - 2].length();
        }


        for (int i = 0; i < totalPerms; i++) {
            StringBuilder sb = new StringBuilder();
            int factor = totalPerms;
            for (char c : digits.toCharArray()) {

                String current = arr[c - '0'- 2];
                factor /= current.length();
                int charidx = (i / factor) % current.length();
                sb.append(current.charAt(charidx));
            }
            ans.add(sb.toString());
        }

        return ans;

    }
}
