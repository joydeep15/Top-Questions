package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Knapsack {

    public static void main(String[] args) {

        int[] val = {1, 2, 3};
        int[] weight = {4, 5, 1};

        System.out.println(knapSackIterative(4, weight, val));


    }
    static int knapSack(int W, int wt[], int val[], int n, Map<String, Integer> map)
    {
        String key = W + "," + n;
        if (n == 0) {
            map.put(key, 0);
            return map.get(key);
        }

        int itemIgnored = knapSack(W, wt, val, n - 1, map);
        int itemPicked = 0;

        if (W - wt[n - 1] >= 0) {
            //valid selection
            itemPicked = val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1, map);
        }

        map.put(key, Math.max(itemIgnored, itemPicked));
        return map.get(key);
    }

    static int knapSackIterative(int weight, int[] wt, int[] val) {

        int dp[][] = new int[val.length + 1][weight + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }

        for (int value = 1; value < dp.length; value++) {
            for (int curWeight = 1; curWeight <= weight; curWeight++) {

                int itemIgnored = dp[value - 1][curWeight];
                int itemTaken = 0;
                if (curWeight - wt[value - 1] >= 0) {
                    itemTaken = val[value - 1] + dp[value - 1][curWeight - wt[value - 1]];
                }

                dp[value][curWeight] = Math.max(itemIgnored, itemTaken);
            }
        }

        return dp[val.length][weight];
    }
}
