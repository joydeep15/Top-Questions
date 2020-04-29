package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KSmallest {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while(t!=0){
            t--;
            int len = Integer.parseInt(bfr.readLine().trim());
            String[] elements = bfr.readLine().trim().split("\\s+");
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

            for (int i = 0; i < len; i++) {
                pq.add(Integer.parseInt(elements[i]));
            }

            int k = Integer.parseInt(bfr.readLine().trim());

            sb.append(findKSmallest(pq, k)).append("\n");

        }

        System.out.print(sb);
    }

    private static Integer findKSmallest(PriorityQueue<Integer> pq, int k) {

        int popCount = k - 1;
        while (popCount > 0){
            pq.poll();
            popCount--;
        }

        return pq.peek();
    }
}
