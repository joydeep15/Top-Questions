package hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequencyMap <T> {
    private final Map<T, Integer> map;
    public FrequencyMap(){
        map = new HashMap<>();
    }
    public void add(T item){
        if(map.containsKey(item)){
            map.put(item, map.get(item) + 1);
        }else{
            map.put(item, 1);
        }
    }
    public void remove(T item){
        if(map.containsKey(item)){
            if(map.get(item) == 1){
                map.remove(item);
            }else{
                map.put(item, map.get(item) - 1);
            }
        }
    }

    public int size(){
        return map.size();
    }
}
