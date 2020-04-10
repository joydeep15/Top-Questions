package  arrays;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfInversions {

    private static int [] temp;
    public static void createTempArray(int len){
        temp = new int[len];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        while (t!=0){
            t--;
            int len = Integer.parseInt(bfr.readLine());
            int[] arr = new int[len];

            String[] elements = bfr.readLine().split("\\s+");
            for(int i=0; i < len ; i++){
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(countInversions(arr));

        }



    }

    private static long countInversions(int[] arr) {
        createTempArray(arr.length);
        long x = mergeSortInversions(arr, 0, arr.length - 1);
        return x;
    }

    private static long mergeSortInversions(int[] arr, int l, int r) {

        long inversions = 0;
        if(l < r){
            int mid = l + (r - l) / 2;
            inversions+= mergeSortInversions(arr, l, mid );
            inversions+= mergeSortInversions(arr, mid+1, r);
            inversions+= merge(arr, l, mid, r);
        }
        return inversions;

    }

    private static long merge(int[] arr, int l, int m, int r) {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        // Fill from the rest of the left subarray
        while (i < left.length)
            arr[k++] = left[i++];

        // Fill from the rest of the right subarray
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }
}
