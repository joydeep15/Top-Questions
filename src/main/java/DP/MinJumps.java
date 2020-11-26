package DP;

import java.util.Arrays;

public class MinJumps {

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9,0,0,0,0,0,0,0,0,0,1,2};
        System.out.println(minJumps(arr));
    }
    static int minJumps(int arr[]){

        return minJumpsIter(arr, 0);

    }

    //add a hashmap for dp
    private static int minJumpsUtil(int[] arr, int index) {

        if (arr == null || index >= arr.length - 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[index]; i++) {

            if ((index + i) < arr.length && arr[index + i] == 0) {
                continue;
            }
            min = Math.min(min, 1 +minJumpsUtil(arr, index + i));
        }
        return min;
    }

    private static int minJumpsIter(int[] arr, int index) {

        if (arr == null || arr.length < 1) {
            return 0;
        }

        if (arr[0] == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 1;
        }

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 0);
//        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {

                if (j + arr[j] >= i && dp[j] != -1) {
                    min = Math.min(min, 1 + dp[j]);
                }

            }

            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

//        for (int n : dp) {
//            System.out.print(n + " ");
//        }
        return dp[dp.length-1];
    }

}
