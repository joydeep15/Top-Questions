package DivideAndConquer;

public class MedianSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {1,3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {

        if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1);
        }

        int x = arr1.length;
        int y = arr2.length;


        int low = 0;
        int high = x;

        while (low <= high) {


            int partitionX = low + (high - low) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : arr2[partitionY - 1];


            int minRightX = partitionX == x ? Integer.MAX_VALUE : arr1[partitionX];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : arr2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //found
                if (((x + y) % 2) == 0) {
                    //even
                    return ( ((double) Math.max(maxLeftX,maxLeftY) ) + Math.min(minRightX,minRightY) )/2;
                }

                return Math.max(maxLeftX, maxLeftY);

            } else if (maxLeftX > minRightY) {
                //go right in x
                high = partitionX - 1;
            }else {
                low = partitionX + 1;
            }

        }
        return 0;

    }
}
