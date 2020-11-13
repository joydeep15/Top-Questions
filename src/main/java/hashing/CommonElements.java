package hashing;

import java.util.*;

public class CommonElements {

    public static void main(String[] args) {

        common_element(Arrays.asList(3, 4, 2, 4), Arrays.asList(3, 2, 2, 7)).
                forEach(s -> System.out.print(s + " "));
        System.out.println();

    }

    public static ArrayList<Integer> common_element(List<Integer>v1, List<Integer>v2)
    {

        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        v1.forEach(v -> freq.put(v, 0));
        v1.forEach(v -> freq.put(v, freq.get(v) + 1));

        v2.forEach(v->{
            if (freq.containsKey(v)) {
                int val = freq.get(v);
                if (val > 0) {
                    result.add(v);
                    freq.put(v, val - 1);
                }else {
                    freq.remove(v);
                }
            }
        });

        Collections.sort(result);

        return result;


    }
}
