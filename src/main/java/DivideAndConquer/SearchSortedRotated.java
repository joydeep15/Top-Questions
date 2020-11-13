package DivideAndConquer;

import utilities.BReader;

import java.io.IOException;

public class SearchSortedRotated {
//    https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
//https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array/0
    public static void main(String[] args) throws IOException {
        int t = BReader.getInteger();
        StringBuilder sb = new StringBuilder();
        while (t != 0) {
            t--;
            int el = BReader.getInteger();
            int[] elms = BReader.getIntegerArray("\\s+");
            int target = BReader.getInteger();
            sb.append(search(elms, target)).append("\n");

        }
    }

    public static int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int pivot = getPivot(nums);
        //we will split the array into two now

        int searchResLeft = binarySearch(nums, 0, pivot - 1, target);
        int searchResRight = binarySearch(nums, pivot, nums.length - 1, target);

        if (searchResLeft != -1) {
            return searchResLeft;
        }
        else return searchResRight;
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {

        if (!validRange(nums, start, end)) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;

    }

    private static boolean validRange(int[] nums, int start, int end) {

        if (start > end) {
            return false;
        }

        if (start < 0) {
            return false;
        }

        return start < nums.length && end < nums.length;
    }

    private static int getPivot(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid+1;
            }else if (nums[mid] < nums[start]) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return nums.length - 1;
    }
}
