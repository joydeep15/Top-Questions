package arrays;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fruit-into-baskets/
public class FruitBaskets {

    public static int totalFruit(int[] tree) {

        //sliding window
        Map<Integer, Integer> freqMap = new HashMap<>();

        int start = 0;
        int maxLen = 0;

        for(int i = 0; i < tree.length; i++){

            if(freqMap.size() == 2 && ! freqMap.containsKey(tree[i])){

                //moving start to the right
                while(freqMap.size() != 1){
                    System.out.println(freqMap);
                    delete(freqMap, tree[start]);
                    start++;
                }
            }

            add(freqMap, tree[i]);

            maxLen = Math.max(maxLen, i - start + 1);

        }
        return maxLen;
    }

    public static void add(Map<Integer, Integer> map, Integer toAdd){

        if(map.containsKey(toAdd)){
            map.put(toAdd, map.get(toAdd)+1);
        }else{
            map.put(toAdd, 1);
        }

    }

    public static void delete(Map<Integer, Integer> map, Integer toDel){
        if(map.containsKey(toDel)){
            if(map.get(toDel) == 1){
                map.remove(toDel);
            }else{
                map.put(toDel, map.get(toDel) - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
