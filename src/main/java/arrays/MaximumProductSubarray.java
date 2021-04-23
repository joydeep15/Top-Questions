package arrays;

//https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {

    /**
     * Idea behind it is very simple. You have 2 situations (forget about 0's for a second).
     * First scenario: you have even number of negative numbers. Then - the solutions is whole array.
     * Second scenario: you have odd number of negative numbers.
     * Then - the solutions starts from left till the last negiative number or the other way around.
     *
     * Now, think about 0's.
     * They are nothing different than just start of an array, and you don't have to think about them at all :)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int product = 1;
        for( int num : nums ){
            product *= num;
            maxProduct = Math.max(product, maxProduct);
            if(product == 0){
                product = 1;
            }
        }

        product = 1;
        for(int i = nums.length -1; i > -1; i--){
            product *= nums[i];
            maxProduct = Math.max(product, maxProduct);
            if(product == 0){
                product = 1;
            }
        }
        return maxProduct;
    }

    public int maxProductKadane(int[] nums) {

        int result = nums[0];
        int maxTillHere = nums[0];
        int minTillHere = nums[0];

        for(int i = 1; i < nums.length ; i++){

            int temp = maxTillHere;
            maxTillHere = getMax(nums[i], temp * nums[i],
                    minTillHere * nums[i]);

            minTillHere = getMin(nums[i], minTillHere * nums[i],
                    temp * nums[i]);

            result = Math.max(result, maxTillHere);
        }

        return result;
    }

    public int getMax(int... nums){

        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int getMin(int... nums){

        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            min = Math.min(min, nums[i]);
        }
        return min;
    }

}
