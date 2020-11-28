package string;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("joydeep", "peedyojo"));
    }
    public static boolean isAnagram(String a,String b)
    {

        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            Character ch = a.charAt(i);
            map.computeIfPresent(ch, (key, value) -> value + 1);
            map.putIfAbsent(ch, 1);
        }

        for (int i = 0; i < b.length(); i++) {
            Character ch = b.charAt(i);
            map.computeIfPresent(ch, (key, value) -> value - 1);
            map.putIfAbsent(ch, -1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;

    }
}
