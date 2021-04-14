package stack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/
public class SumOfSubArrayMinimums {

    public int sumSubarrayMins(int[] arr) {


        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException();
        }

        List<Integer> leftElements = getMinLeftElements(arr);
        List<Integer> rightElements = getMinRightElements(arr);
        Collections.reverse(rightElements);


        long MOD = (long) 1e9 + 7;
        long sum = 0;
        for(int i=0; i < arr.length; i++){
            sum = (sum + (long)arr[i] * leftElements.get(i) * rightElements.get(i)) % MOD;
        }
        return (int)sum;

    }

    /**
     * The last thing that needs to be mentioned for handling duplicate elements:
     * Method: Set strict less and non-strict less(less than or equal to) for finding NLE and PLE respectively. The order doesn't matter.
     * This is done to avoid counting twice
     * @param arr
     * @return
     */
    private List<Integer> getMinRightElements(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> leftMinCount = new ArrayList<>();

        for(int i=arr.length - 1; i > -1; i--){

            while ( ! stack.isEmpty() && arr[i] <= arr[stack.peek()] ){
                stack.pop();
            }

            int current_ple = stack.isEmpty() ? -1 : stack.peek();
            current_ple = current_ple == -1 ? arr.length - i : current_ple - i;
            leftMinCount.add(current_ple);

            stack.push(i);
        }
        return leftMinCount;
    }

    /**
     * returns a list left, where left[i] denotes number of contiguous elements
     * to the left for which arr[i] is minimum
     * @param arr array
     * @return
     */
    private List<Integer> getMinLeftElements(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> leftMinCount = new ArrayList<>();

        for(int i=0; i < arr.length; i++){

            while ( ! stack.isEmpty() && arr[i] < arr[stack.peek()] ){
                stack.pop();
            }

            int current_ple = stack.isEmpty() ? -1 : stack.peek();
            current_ple = current_ple == -1 ? i + 1 : i - current_ple;
            leftMinCount.add(current_ple);

            stack.push(i);
        }
        return leftMinCount;
    }



}
