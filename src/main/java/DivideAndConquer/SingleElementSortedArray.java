package DivideAndConquer;

import java.util.Arrays;

public class SingleElementSortedArray {
//https://leetcode.com/problems/single-element-in-a-sorted-array/

    public static void main(String[] args) {
        int[] x = {1, 1, 2, 2, 4, 4, 6, 6};
        Arrays.sort(x);
        System.out.println(x.length);
        System.out.println(singleNonDuplicate(x));
    }

    public static int singleNonDuplicate(int[] x) {
        int el = singleNonDuplicateIdx(x);
        if (el != -1) {
            return x[el];
        }else
            return -1;
    }

    public static int singleNonDuplicateIdx(int[] nums) {

        if (nums.length ==1) {
            return 0;
        }

        if (nums.length == 0 || nums.length == 2) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (isOrderCorrect(mid, nums)) {
                start = mid + 1;
            }else {
                break;
            }
        }

        //order is incorrect rn
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (!isOrderCorrect(mid, nums)) {

                //check if mid is unique
                if (mid == 0) {
                    if (nums[mid] != nums[mid + 1]) {
                        return mid;
                    } else return -1;
                } else if (mid == nums.length - 1) {
                    if (nums[mid] != nums[mid - 1]) {
                        return mid;
                    } else return -1;
                } else {
                    if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                        return mid;
                    }
                }

                //order is incorrect, what to do now?
                //go left
                end = mid - 1;
            } else {
                //order is correct
                //go right
                start = mid + 1;
            }
        }

        return -1;




    }

    private static boolean isOrderCorrect(int index, int[] nums) {
        if (index % 2 == 0) {
            if (index + 1 < nums.length && nums[index] == nums[index + 1]) {
                return true;
            } else return false;
        }else {
            return nums[index] == nums[index - 1];
        }

    }
}
