package sorting;

public class MergeSort {

    int[] temp;
    public  void sort(int[] array){
        temp = new int[array.length];
        mergeSort(array, 0, array.length-1);
    }

    private  void mergeSort(int[] array, int low, int high) {
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid+1, high);
            merge(array, low, mid, high);
        }
    }

    private void merge(int[] array, int low, int mid, int high) {
        // sorted from low->mid & mid+1 -> high
        for(int i=low; i<=mid; i++){
            temp[i] = array[i];
        }

        for(int i=mid+1; i<=high; i++){
            temp[i] = array[i];
        }
        
    }

    public MergeSort(){
    }

}
