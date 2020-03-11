package sorting;

public class QuickSort {


    private static int partition(int[] array, int startIdx, int endIdx){
        int pivot = array[endIdx];
        int leftBoundary = startIdx - 1;
        for (int j = startIdx; j <= endIdx - 1; j++) {

            if(array[j] < pivot){
                leftBoundary++;
                swap(array, leftBoundary, j);
            }
        }

        leftBoundary++;
        swap(array, leftBoundary , endIdx);
        return leftBoundary;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void doSort(int[] array, int low, int high){

        if(low<high){
            int pivot = partition(array, low, high);
            doSort(array, low, pivot-1);
            doSort(array, pivot + 1, high);
        }
    }

    public static void sort(int[] array){
        doSort(array, 0, array.length-1);
    }

}

