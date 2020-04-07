package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
*
*  Given two arrays X and Y of positive integers, find number of pairs such that xy > yx (raised to power of) where x is an element from X and y is an element from Y.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test consists of three lines. The first line of each test case consists of two space separated M and N denoting size of arrays X and Y respectively. The second line of each test case contains M space separated integers denoting the elements of array X. The third line of each test case contains N space separated integers denoting elements of array Y.

Output:
Corresponding to each test case, print in a new line, the number of pairs such that xy > yx.

Constraints:
1 ≤ T ≤ 100
1 ≤ M, N ≤ 105
1 ≤ X[i], Y[i] ≤ 103

Example:
Input
1
3 2
2 1 6
1 5

Output
3

Explanation:
Testcase 1: The pairs which follow x^y > y^x are as such: 2^1 > 1^2,  2^5 > 5^2 and 6^1 > 1^6
* */
public class NumberOfPairsXY {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());

        StringBuilder sb = new StringBuilder();
        while(t!=0){
            t--;
            String[] lineParser = bfr.readLine().split("\\s+");

            int len_x = Integer.parseInt(lineParser[0]);
            int len_y = Integer.parseInt(lineParser[1]);

            int[] X = new int[len_x];
            int[] Y = new int[len_y];

            lineParser = bfr.readLine().split("\\s+");

            for(int i = 0; i < len_x; i++) {
                X[i] = Integer.parseInt(lineParser[i]);
            }


            lineParser = bfr.readLine().split("\\s+");

            for(int i = 0; i < len_y; i++) {
                Y[i] = Integer.parseInt(lineParser[i]);
            }

            sb.append(getNumberOfPairs(X, Y) + "\n");
        }

        System.out.println(sb);


    }

    private static long getNumberOfPairs(int[] x, int[] y) {

        Arrays.sort(y);
        int[] counts = new int[5];

        for(int i=0;i<y.length; i++){
            if( y[i] < 5){
                counts[y[i]]++;
            }else break;
        }

        long retVal = 0;

        for(int el : x ){

            if( el == 0 )
            {
                continue;
            }
            else if( el == 1){
                retVal += counts[0];
                continue;
            }

            int idx = Arrays.binarySearch(y, el);
            if( idx < 0){
                //see javadoc
                idx = (idx + 1) * -1;

            }
            else{
                //match found, skip to next larger number
                while(idx < y.length && y[idx] == el ){
                    idx++;
                }
            }

            retVal += (y.length - idx);

            //add pairs for 0 and 1
            retVal += counts[0] + counts[1];

            if( el == 2 ){
                //remove pairs for 3 and 4 as not valid
                retVal -= (counts[3] + counts[4]);
            }

            if ( el == 3 ){
                retVal += counts[2];
            }


        }
        return retVal;
    }
}
