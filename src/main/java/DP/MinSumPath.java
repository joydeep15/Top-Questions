package DP;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinSumPath {

        @Test
        public void getSolution(){
            MinSumPath ms = new MinSumPath();
            int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
            Assert.assertEquals(7, ms.minPathSum(grid));
        }

        public int minPathSum(int[][] grid) {
            if(grid == null || grid.length ==0){
                return 0;
            }
            int[] dp = new int[grid[0].length];
            for(int i = 0; i < grid.length; i ++){
                for (int j = 0; j < grid[i].length; j++){
                    // dp[j] = grid[i][j] + min ( dp[j], dp[j-1] )
                    if(i == 0){
                        dp[j] = grid[i][j] + ( j ==0 ? 0 : dp[j-1] );
                        continue;
                    }
                    if(j ==0){
                        dp[j] = grid[i][j] + dp[j];
                        continue;
                    }
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
                }
            }
            return dp[grid[0].length-1];
        }

}
