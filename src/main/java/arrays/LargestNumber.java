package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.
 *
 * Input:
 * The first line of input consists number of the test cases. The description of T test cases is as follows:
 * The first line of each test case contains the size of the array, and the second line has the elements of the array.
 *
 * Output:
 * In each separate line print the largest number formed by arranging the elements of the array in the form of a string.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 102
 * 0 ≤ A[i] ≤ 103
 *
 * Example:
 * Input:
 * 2
 * 5
 * 3 30 34 5 9
 * 4
 * 54 546 548 60
 *
 * Output:
 * 9534330
 * 6054854654
 */
public class LargestNumber {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine().trim());

        StringBuilder sb = new StringBuilder();
        while(t!=0){
            t--;
            int len = Integer.parseInt(bfr.readLine().trim());
            String[] elements = bfr.readLine().split("\\s+");
            sb.append(getLargest(elements)).append("\n");
        }

        System.out.println(sb);


    }
    public static  int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
    }
    private static String getLargest(String[] elements) {

//        return "" + compare(elements[0], elements[1]);
        Comparator<String> com = LargestNumber::compare;
        Arrays.sort(elements,com);
        StringBuilder sb = new StringBuilder();
        for(String ele : elements){
            sb.append(ele);
        }
        return sb.toString();
    }

}
