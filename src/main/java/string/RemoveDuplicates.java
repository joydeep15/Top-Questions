package string;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

    String removeDups(String s) {
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : set) {
            sb.append(c);
        }
        return sb.toString();
    }
}
