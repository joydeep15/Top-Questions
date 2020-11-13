package hashing;

import java.util.HashMap;

public class SubarrayZeroSum {

    public static void main(String[] args) {

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr, arr.length));
    }

    static int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> occuredSum = new HashMap<>();
        int cum_sum = 0;
        int maxLength = 0;

        for(int i=0; i < arr.length; i++){

            cum_sum+=arr[i];
            if(cum_sum == 0){
                maxLength = Math.max(maxLength, i + 1);
            }
            if(occuredSum.containsKey(cum_sum)){
                //occured previously so zero sum
                int start = occuredSum.get(cum_sum);
                int subarray_length = i - start;
                maxLength = Math.max(maxLength, subarray_length);
            }

            if(!occuredSum.containsKey(cum_sum)) {
                occuredSum.put(cum_sum, i);
            }
        }
        return maxLength;
    }



}
