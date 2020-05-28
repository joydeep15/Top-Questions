package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Imagine you have a special keyboard with the following keys:
 * Key 1:  Prints 'A' on screen
 * Key 2: (Ctrl-A): Select screen
 * Key 3: (Ctrl-C): Copy selection to buffer
 * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed. If you can only press the keyboard for N times (with the above four keys), write a program to produce maximum numbers of A's. That is to say, the input parameter is N (No. of keys that you can press), the output is M (No. of As that you can produce).
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, N is the number of key.
 *
 * Output:
 * Print maximum number of A's. Print -1, if N is greater than 75.
 *
 * Constraints:
 * 1 ≤ T ≤ 50
 * 1 ≤ N ≤ 75
 *
 * Example:
 * Input:
 * 2
 * 3
 * 7
 *
 * Output:
 * 3
 * 9
 *
 * Explanation:
 * Testcase 1:  We can at most get 3 A's on screen by pressing following key sequence.
 * A, A, A.
 * Testcase 2: We can at most get 9 A's on screen by pressing following key sequence.
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 */
public class SpecialKeyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        StringBuilder sb = new StringBuilder();
        while(t!=0){

            t--;
            int destination = Integer.parseInt(bfr.readLine());
            sb.append(getMaxA(destination)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getMaxA(int destination) {

        // O(1) space by storing last 5 values
        int[] dp = new int[destination+1];

        for(int i=1;i<=destination;i++){

            if(i<=6){
                dp[i] = i;
            } else dp[i] = max(
                    1 + dp[i - 1],
                    2 * dp[i-3],
                    3 * dp[i-4],
                    4 * dp[i-5]
            );
        }

        return dp[destination];

    }

    private static int max(int ... elements) {

        if(elements.length == 0){
            return -1;
        }
         int result = elements[0];
        for(int element : elements){
            result = Math.max(result, element);
        }
        return result;
    }


}
