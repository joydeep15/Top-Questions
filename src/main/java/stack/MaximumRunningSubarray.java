package stack;

//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0

import utilities.BReader;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumRunningSubarray {
    public static void main(String[] args) throws IOException {

        int t = BReader.getIntLine();
        StringBuilder sb = new StringBuilder();
        while (t > 0) {
            t--;
            int[] dims = BReader.getIntLine("\\s+");

            int[] elements = BReader.getIntLine("\\s+");
            sb.append(getMaxRunning(elements, dims[1])).append("\n");
        }

        System.out.println(sb);
    }

    private static String getMaxRunning(int[] elements, int k) {
//        1 2 3 1 0 1 4 5 2 3 0
//        3 3 3 1 4 5 5 5 3

        if (elements.length < k) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < k; i++) {

            while (dq.size() > 0 && elements[dq.peekLast()] < elements[i]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        //initial dq built
        sb.append(elements[dq.peekFirst()]).append(" ");

        for (int i = k; i < elements.length; i++) {

            //index out of scope
            if (dq.size() > 0 && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            //new local maxima
            while (dq.size() > 0 && elements[dq.peekLast()] <= elements[i]) {
                dq.pollLast();
            }

            dq.addLast(i);
            sb.append(elements[dq.peekFirst()]).append(" ");

        }

        return sb.toString();

    }
}
