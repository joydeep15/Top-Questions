package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

enum Braces{
    ROUND("(",")"),
    CURLY("{", "}"),
    SQUARE("[", "]"),
    INVALID("*","/");

    private String opening;
    private String closing;

    Braces(String opening, String closing) {
        this.opening = opening;
        this.closing = closing;
    }

    public String getOpening() {
        return opening;
    }
    public String getClosing() {
        return closing;
    }
}
public class Parenthesis {
//    https://practice.geeksforgeeks.org/problems/parenthesis-checker/0

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine().trim());

        StringBuilder sb = new StringBuilder();
        while (t != 0) {
            t--;
            String s = bfr.readLine();
            sb.append( isBalanced(s) ?  "balanced" :"not balanced").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isBalanced(String s) {
        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            String item = ""+c;
            Braces brace = getBraceFamily(item);

            if (item.equals(brace.getOpening())){
                stack.push("" + c);
            } else {

                if (stack.size() <= 0) {
                    return false;
                }else if (item.equals(brace.getClosing()) && stack.peek().equals(brace.getOpening())) {
                    stack.pop();
                } else return false;
            }

        }

        return stack.size() == 0;
    }

    private static Braces getBraceFamily(String c) {
        for (Braces b : Braces.values()) {
            if (c.equals(b.getOpening()) || c.equals(b.getClosing())) {
                return b;
            }
        }
        return Braces.INVALID;
    }

}

