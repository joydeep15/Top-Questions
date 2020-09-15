package search;

import java.util.List;

public class BinarySearch {

    public static Integer binarySearch(List<Integer> nums, Integer target) {

        int start = 0;
        int end = nums.size() - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target.equals(nums.get(mid))) {
                return mid;
            } else if (target > nums.get(mid)) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
