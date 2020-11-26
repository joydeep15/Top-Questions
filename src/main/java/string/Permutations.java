package string;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums).forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        permuteUtil(nums, 0, nums.length - 1, result);
        return result;
    }

    private static void permuteUtil(int[] nums, int start, int end, List<List<Integer>> result) {

        if (start == end) {
            addToResult(nums, result);
        }
        if (start > end) {
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(nums, start, i);
            permuteUtil(nums, start + 1, end, result);
            swap(nums, i, start);
        }

    }

    private static void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }

    private static void addToResult(int[] nums, List<List<Integer>> result) {

        List<Integer> temp = new ArrayList<>();

        for (int num : nums) {
            temp.add(num);
        }

        result.add(temp);
    }

}
