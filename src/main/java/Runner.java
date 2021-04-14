
import sorting.MergeSort;
import stack.SumOfSubArrayMinimums;


public class Runner {
    public static int compare(Integer o1, Integer o2) {
        return o2-o1;
    }

    public static void main(String[] args) {

        SumOfSubArrayMinimums s = new SumOfSubArrayMinimums();
        int[] arr = {11,81,94,43,3};
        System.out.println(s.sumSubarrayMins(arr));

    }
}
