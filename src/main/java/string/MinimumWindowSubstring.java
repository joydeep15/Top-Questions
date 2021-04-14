package string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring ms = new MinimumWindowSubstring();
        System.out.println(ms.minWindow("ABC", "X"));
    }

    public String minWindow(String s, String t) {

        Map<Character, Integer> required = new HashMap<>();
        for(int i =0; i < t.length(); i++){
            add(required, t.charAt(i));
        }

        int start = 0;
        int end = 0;
        int minStart = 0;
        int minEnd = 0;
        int minLength = Integer.MAX_VALUE;

        Map<Character, Integer> current = new HashMap<>();
        while (start < s.length() && end < s.length() ){

            add(current, s.charAt(end));
            if(conditionalEquals(current, required)){

                while (start <= end && conditionalEquals(current, required)) {

                    if ((end - start) < minLength) {
                        minLength = end - start;
                        minStart = start;
                        minEnd = end;
                    }
                    delete(current, s.charAt(start));
                    start++;
                }
            }
            end++;
        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minStart, minEnd+1);
    }

    private boolean conditionalEquals(Map<Character, Integer> source,
                                      Map<Character, Integer> target){

        for(Map.Entry<Character, Integer> tar : target.entrySet()){

            if(!source.containsKey(tar.getKey())){
                return false;
            }

            if(source.get(tar.getKey()) < tar.getValue()){
                return false;
            }

        }

        return true;


    }

    private void add(Map<Character, Integer> freqMap, Character ch){
        if(freqMap.containsKey(ch)){
            freqMap.put(ch, freqMap.get(ch)+1);
        }else{
            freqMap.put(ch, 1);
        }
    }

    private void delete(Map<Character, Integer> freqMap, Character ch){

        if(freqMap.containsKey(ch)){
            if(freqMap.get(ch) == 1){
                freqMap.remove(ch);
            }else{
                freqMap.put(ch, freqMap.get(ch) -1 );
            }
        }

    }


}
