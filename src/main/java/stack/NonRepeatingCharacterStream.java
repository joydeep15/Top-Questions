package stack;

import utilities.BReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NonRepeatingCharacterStream {

//    https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0

    public static void main(String[] args) throws IOException {

        int t = BReader.getInteger();
        StringBuilder sb = new StringBuilder();
        while (t != 0) {
            t--;

            int n = BReader.getInteger();
            String[] charStream = BReader.getStringLine("\\s+");
            sb.append(getNonRepeating(charStream));
            sb.append("\n");

            }

        System.out.println(sb);
    }

    private static String getNonRepeating(String[] charStream) {
        Queue<String> q = new LinkedList<>();
        Map<String, Boolean> isStrDuplicate = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (String current: charStream ) {

            if (isStrDuplicate.containsKey(current)) {
                isStrDuplicate.put(current, true);
            } else {
                isStrDuplicate.put(current, false);
            }

            if (!isStrDuplicate.get(current)) {
                q.add(current);
            }

            while (q.size() > 0 && isStrDuplicate.get(q.peek())) {
                q.poll();
            }

            if (q.size() > 0) {
                sb.append(q.peek());
            }else {
                sb.append("-1");
            }

            sb.append(" ");
        }

        return sb.toString().trim();
    }

}
