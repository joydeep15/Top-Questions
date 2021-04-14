package recursion;

import java.util.*;

public class LetterCombinationsPhone {

    static final Map<Integer, String> letters = new HashMap<Integer, String>(){{
        put(2,"abc");   put(6, "mno");
        put(3, "def");  put(7, "pqrs");
        put(4, "ghi");  put(8, "tuv");
        put(5, "jkl");  put(9, "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0){
            return combinations;
        }
        letterCombinations(digits,combinations,new StringBuilder(),0);
        return combinations;

    }

    public static void letterCombinations(String digits, List<String> combinations,
                                          StringBuilder currentString, int index){

        if (currentString.length() == digits.length()) {
            combinations.add(currentString.toString());
        }

        if(index >= digits.length()){
            return;
        }

        String currentDigits = letters.get( digits.charAt(index) - '0');

        for (int i = 0; i < currentDigits.length(); i++ ){
            currentString.append(currentDigits.charAt(i));
            letterCombinations(digits, combinations, currentString, index+1);
            if(currentString.length() > 0){
                currentString.deleteCharAt(currentString.length() - 1 );
            }
        }

    }


    public static void main(String[] args) {

        String digs = "23";
        letterCombinations(digs).forEach(System.out::println);

    }


}
