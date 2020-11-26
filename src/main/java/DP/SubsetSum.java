package DP;

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 1, 5};
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        System.out.println(equalPartition(arr, 0, 0, sum));

    }

    //add hashmap to make efficient
    static boolean equalPartition(int arr[], int index, int currentSum, int totalSum)
    {
        if (arr == null || arr.length == 1 || totalSum % 2 == 1 || index >= arr.length) {
            return false;
        }

        if (currentSum == (totalSum - currentSum)) {
            return true;
        }

        boolean picked = equalPartition(arr, index + 1, currentSum + arr[index], totalSum);
        boolean notPicked = equalPartition(arr, index + 1, currentSum, totalSum);

        return picked || notPicked;
    }

    static boolean equalPartitionIter(int arr[]) {
        if (arr == null || arr.length == 1  ) {
            return false;
        }

        int totalSum = 0;
        for (int a : arr) {
            totalSum += a;
        }

        if (totalSum % 2 == 1) {
            return false;
        }

        totalSum /= 2;

        boolean[][] dp = new boolean[arr.length + 1][totalSum + 1];

        for (int index = 0; index <= arr.length; index++) {
             for (int currentSum = 0; currentSum <= totalSum; currentSum++) {

                if (currentSum == 0) {
                    dp[index][currentSum] = true;
                    continue;
                }

                 if (index == 0) {
                     break;
                 }

                 if (arr[index] < currentSum) {
                     dp[index][currentSum] = dp[index - 1][currentSum];
                 }else {
                     dp[index][currentSum] = dp[index - 1][currentSum] || dp[index - 1][currentSum - arr[index]];
                 }
            }
        }
        return dp[arr.length][totalSum];
    }
}
