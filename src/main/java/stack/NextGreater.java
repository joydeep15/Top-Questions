package stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class NextGreater {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        long t = Long.parseLong(bfr.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t!=0) {
            t--;
            int len = Integer.parseInt(bfr.readLine().trim());
            String[] elements = bfr.readLine().split("\\s+");
            long[] ele = new long[len];

            for (int i = 0; i < len; i++) {
                ele[i] = Long.parseLong(elements[i]);
            }
            List<Long> l=getNextGreaterList(ele);

            for (Long el : l) {
                sb.append(el).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    private static List<Long> getNextGreaterList(long[] elements) {
        List<Long> res = new ArrayList<>();
        Stack<Long> stack = new Stack<>();
        for (int i = elements.length - 1; i >= 0; i--) {

            if (stack.empty()) {
                res.add((long) -1);
            } else if (stack.peek() > elements[i]) {
                res.add(stack.peek());
            }else{
                while (!stack.empty() && stack.peek() < elements[i] ) {
                    stack.pop();
                }

                res.add(stack.empty() ? (long) -1 : stack.peek());
            }

            stack.add(elements[i]);
        }

        Collections.reverse(res);
        return res;
    }
}
