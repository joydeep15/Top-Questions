package arrays;
//
//Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on...
//
//        Note: O(1) extra space is allowed. Also, try to modify the input array as required.
//
//        Input:
//        First line of input conatins number of test cases T. First line of test case contain an integer denoting the array size N and second line of test case contain N space separated integers denoting the array elements.
//
//        Output:
//        Output the modified array with alternated elements.
//
//        Constraints:
//        1 <=T<= 100
//        1 <=N<= 107
//        1 <=arr[i]<= 107
//
//        Example:
//        Input:
//        2
//        6
//        1 2 3 4 5 6
//        11
//        10 20 30 40 50 60 70 80 90 100 110
//
//        Output:
//        6 1 5 2 4 3
//        110 10 100 20 90 30 80 40 70 50 60

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RearrangeArraysAlternatively {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(bfr.readLine());
        StringBuilder sb = new StringBuilder();
        while (t!=0){
            t--;
            int len = Integer.parseInt(bfr.readLine());
            String[] nums = bfr.readLine().split("\\s+");
            long[] arr = new long[len];
            for(int i=0;i<len;i++){
                arr[i] = Integer.parseInt(nums[i]);
            }

            rearrange(arr);
            for(int i=0;i < len ; i++ ){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }

    private static void rearrange(long[] arr) {
        int maxInd = arr.length - 1;
        int minInd = 0;
        long maxVal = arr[maxInd] + 1;
        for(int i=0; i< arr.length ;  i++){
           if(i%2 == 0){
                //even max
               arr[i] = arr[i] + (arr[maxInd] % maxVal) * maxVal;
               maxInd--;
           }
           else{
               arr[i] = arr[i] + (arr[minInd] % maxVal) * maxVal;
               minInd++;
           }
        }

        for(int i=0; i< arr.length ;  i++) {
            arr[i] /= maxVal;
        }
    }
}
