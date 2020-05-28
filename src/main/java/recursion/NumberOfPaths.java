package recursion;
import java.lang.*;
import java.io.*;

/**
 * The problem is to count all the possible paths from top left to bottom right of a MxN matrix with the constraints that from each cell you can either move to right or down.
 *
 * Input:
 * The first line of input contains an integer T, denoting the number of test cases. The first line of each test case is M and N, M is number of rows and N is number of columns.
 *
 * Output:
 * For each test case, print the number of paths.
 *
 * Constraints:
 * 1 ≤ T ≤ 30
 * 1 ≤ M,N ≤ 10
 *
 * Example:
 * Input
 * 2
 * 3 3
 * 2 8
 *
 * Output
 * 6
 * 8
 *
 * Explanation:
 * Testcase 1: Let the given input 3*3 matrix is filled as such:
 * A B C
 * D E F
 * G H I
 * The possible paths which exists to reach 'I' from 'A' following above conditions are as follows:
 * ABCFI, ABEHI, ADGHI, ADEFI, ADEHI, ABEFI.
 *
 * Soln: https://www.youtube.com/watch?v=fpnNaAU0iPk&list=PLmdFyQYShrjfPLdHQxuNWvh2ct666Na3z&index=15
 */
class NumberOfPaths {
    public static void main (String[] args) throws IOException{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        StringBuilder sb = new StringBuilder();
        while(t!=0){
            t--;
            String[] ele = bfr.readLine().split("\\s+");
            int n = Integer.parseInt(ele[0]);
            int m = Integer.parseInt(ele[1]);

            int result;
            if(n==1 || m==1){
                result=1;
            }
            else{
                result=calculateDP(n, m);
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    /**
     * overflows while calculating factorial
     * @param n
     * @param m
     * @return
     */
    private static int calculate(int n, int m) {
        //calculate ncr

        int res = 1;

        for(int i = n ; i<= m+n-2 ; i++){
            res = (res*i) % 1000000007;
            res = (res / (i - n +1))% 1000000007;
        }
        return res;
    }

    private static int calculateDP(int n, int m){
        // Create a 1D array to store results of subproblems
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = (dp[j] + dp[j - 1])% 1000000007 ;
            }
        }

        return dp[n - 1];
    }

}