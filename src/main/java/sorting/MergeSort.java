package sorting;

public class MergeSort {

    int[] temp;
    private void createTempArray(int length){
        temp = new int[length];
    }
    public  void sort(int[] array){
        createTempArray(array.length);
        mergeSort(array, 0, array.length-1);
    }

    private  void mergeSort(int[] array, int low, int high) {
        if(low < high){
            int mid = low + (high - low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid+1, high);
            merge(array, low, mid, high);
        }
    }

    public void merge(int[] array, int low, int mid, int high) {
        // sorted from low->mid & mid+1 -> high

        int leftListCount = mid - low + 1;
        int rightListCount = high - mid - 1;

        if(leftListCount < 1 || rightListCount < 0){
            return;
        }

        for(int i=low; i<=mid; i++){
            temp[i] = array[i];
        }

        for(int i=mid+1; i<=high; i++){
            temp[i] = array[i];
        }

        int leftIterator = low;
        int rightIterator = mid + 1;
        int k;
        for(k=low; k<= high && leftIterator <= mid && rightIterator <=high; k++){

            if( temp[leftIterator] < temp[rightIterator]){
                array[k] = temp[leftIterator];
                leftIterator++;
            }else{
                array[k] = temp[rightIterator];
                rightIterator++;
            }
        }

        if(leftIterator <= mid){
            //populate remaining members of the left list
            while (leftIterator<=mid){
                array[k] = temp[leftIterator];
                k++;
                leftIterator++;
            }
        }

        if(rightIterator <= high){
            while (rightIterator <= high){
                array[k] = temp[rightIterator];
                k++;
                rightIterator++;
            }
        }

        return;
        
    }

    public MergeSort(){
    }

}
