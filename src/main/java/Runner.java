import sorting.MergeSort;
import sorting.QuickSort;
import utilities.Graph;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {


        int[] arr1 = {9,7,8,7,6,2,5,1};
        MergeSort mrs = new MergeSort();
        mrs.sort(arr1);
        System.out.println(Arrays.toString(arr1));

    }


}
