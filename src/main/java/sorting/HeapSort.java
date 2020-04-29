package sorting;


public class HeapSort {

    public HeapSort(){

    }

    public void buildMaxHeap(int[] arr){

        int len = arr.length-1;
        for(int i = len/2 ; i>-1 ; i--)
        {
            maxHeapify(arr, len, i);
        }

    }

    public void maxHeapify(int[] arr, int len, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left <= len && arr[left] > arr[largest]){
            largest = left;
        }


        if(right <= len && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest!=i){

            swap(arr, largest, i);
            maxHeapify(arr, len, largest);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sort(int[] arr){
        buildMaxHeap(arr);

        for(int i = 0; i< arr.length ; i++){
            swap(arr, 0,arr.length-1-i);
            maxHeapify(arr,arr.length-2-i,0);
        }
    }



}
