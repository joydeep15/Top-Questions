package arrays;

import java.lang.reflect.Array;
import java.util.*;

public class RelativeSort {

    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(2, 8, 3, 10, 15, 32, 1, 0, -4);
        List<Integer> arr2 = Arrays.asList(3, -4, 1, 15);

        List<Integer> arr3 = relativeSort(arr1, arr2);
        arr3.forEach(a -> System.out.print(a + " "));

    }

    private static List<Integer> relativeSort(List<Integer> arr1, List<Integer> arr2) {

        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < arr2.size(); i++) {
            positionMap.put(arr2.get(i), i);
        }

        Collections.sort(arr1, (o1, o2) -> {

            if (positionMap.containsKey(o1) && positionMap.containsKey(o2)) {
                return Integer.compare(positionMap.get(o1), positionMap.get(o2));
            }

            return Integer.compare(o1, o2);
        });

        return arr1;

    }
}
