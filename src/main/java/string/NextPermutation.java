package string;

public class NextPermutation {

    public static void main(String[] args) {

        int[] nums = {1, 5, 1};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num+",");
        }
    }

    public static void nextPermutation(int[] nums) {


        int decreasingIdx = -1;
        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] < nums[i + 1]) {
                decreasingIdx = i;
                break;
            }
        }

        if (decreasingIdx == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }



        //get next larger than decreasing
        int swapIdx = decreasingIdx + 1;
        for (int i = decreasingIdx + 2; i < nums.length; i++) {

            if (nums[i] > nums[decreasingIdx] && nums[swapIdx] > nums[i]) {
                swapIdx = i;
            }

        }

        for(int i = decreasingIdx; i < nums.length; i++){
            if(nums[i] == nums[swapIdx]){
                swapIdx = i;
            }

        }

        swap(nums, decreasingIdx, swapIdx);
        reverse(nums, decreasingIdx+1, nums.length - 1);

    }

    private static void reverse(int[] nums, int decreasingIdx, int i) {

        while (decreasingIdx < i) {
            swap(nums, decreasingIdx, i);
            decreasingIdx++;
            i--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
