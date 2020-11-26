package DP;

public class MaximumSumLIS {

    public static void main(String[] args) {

        int[] nums = {1, 101, 2, 3, 100};
        System.out.println(maxSumIS(nums, nums.length));

    }
    public static int maxSumIS(int arr[], int n)
    {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = arr[i];
        }

        for (int j = 1; j < arr.length; j++) {
            int maxVal = dp[j];
            for (int i = 0; i < j; i++) {

                int include = arr[i] < arr[j] ? dp[i] + dp[j] : 0;
                maxVal = Math.max(include, maxVal);
            }
            dp[j] = maxVal;
        }

        int max = dp[0];
        for (int num : dp) {
            max = Math.max(num, max);
        }

        return max;
    }
}
