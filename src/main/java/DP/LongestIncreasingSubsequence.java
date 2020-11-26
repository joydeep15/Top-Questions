package DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));

    }

    public static int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int j = 1; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {

                //if nums[i] < nums[j], j can be used to increase
                // the subsequence ending at i

                int sequenceInc = nums[i] < nums[j] ? dp[i] + 1 :0;
                dp[j] = Math.max(sequenceInc, dp[j]);

            }
        }

        int max = dp[0];
        for (int num : dp) {
            max = Math.max(max, num);
        }

        return max;
    }
}
