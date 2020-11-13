package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortingBasedOnFrequency {
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(bfr.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t != 0) {
            t--;
            int len = Integer.parseInt(bfr.readLine().trim());
            String[] arrst = bfr.readLine().split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String a : arrst) {
                arr.add(Integer.parseInt(a));
            }
            frequencySort(arr);
            arr.forEach(s -> sb.append(s).append(" "));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void frequencySort(List<Integer> arr) {

        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int a : arr) {
            frequency.put(a, 0);
        }

        for (int a : arr) {
            frequency.put(a, frequency.get(a) + 1);
        }

        Collections.sort(arr, ((o2, o1) -> {

            int compareValue = Integer.compare(frequency.get(o1), frequency.get(o2));
            if (compareValue == 0) {
                return Integer.compare(o2, o1);
            }
            return compareValue;
        }));

    }

}
