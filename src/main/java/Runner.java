import sorting.MergeSort;
import sorting.QuickSort;
import utilities.Graph;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

//        int[] arr = {9,7,8,7,6,2,5,1};
//        QuickSort.sort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr1 = {9,7,8,7,6,2,5,1};
        MergeSort mrs = new MergeSort();
        mrs.createTempArray(arr1.length);
        mrs.sort(arr1);
        //        mrs.merge(arr1,0,0,arr1.length-1);
        System.out.println(Arrays.toString(arr1));
    }


}
