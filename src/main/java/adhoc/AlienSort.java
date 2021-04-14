package adhoc;

import java.util.HashMap;
import java.util.Map;

public class AlienSort {

    public static void main(String[] args) {

    }


    public static boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> orderMap = new HashMap<>();
        for(int i=0; i < order.length(); i++){
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++){

            int compare = compare(words[i-1], words[i], orderMap);
            if(compare > 0){
                return false;
            }
        }
        return true;

    }

    private static int compare(String a, String b, Map<Character, Integer> orderMap) {

        int i=0;
        int j=0;

        while ( i < a.length() && j < b.length() ){

            Character aCh = a.charAt(i);
            Character bCh = b.charAt(j);

            if(aCh != bCh){
                return Integer.compare(orderMap.get(aCh), orderMap.get(bCh));
            }else {
                i++;
                j++;
            }
        }

        if( i < a.length()){
            return 1;
        }

        if(j < b.length()){
            return -1;
        }

        return 0;

    }

}
