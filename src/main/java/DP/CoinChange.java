package DP;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        System.out.println(countIterative(coins, coins.length, 4));
    }

    public static long count(int S[], int length, int target)
    {
        if (target == 0) {
            return 1;
        }

        if (length == 0) {
            return 0;
        }


        long coinIgnored = count(S, length - 1, target);
        long coinTaken = 0;

        if (target - S[length - 1] >= 0) {
            coinTaken = count(S, length, target - S[length - 1]);
        }

        return coinIgnored + coinTaken;
    }

    public static long countIterative(int S[], int length, int target) {

        long[][] dp = new long[length + 1][target + 1];

        for (long[] arr : dp) {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    arr[i] = 1;
                    continue;
                }
                arr[i] = 0;
            }
        }

        for (int curLen = 1; curLen <= length; curLen++) {
            for (int curTarget = 1; curTarget <= target; curTarget++) {

                long coinIgnored = dp[curLen - 1][curTarget];
                long coinTaken = 0;
                if (curTarget - S[curLen - 1] >= 0 ) {
                    coinTaken = dp[curLen][curTarget - S[curLen - 1]];
                }

                dp[curLen][curTarget] = coinIgnored + coinTaken;
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

    }
}
