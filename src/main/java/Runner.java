import sorting.HeapSort;

public class Runner {

    public static void main(String[] args) {


        int[] arr1 = {1,5,2,7,3,8};
        HeapSort mh = new HeapSort();
        mh.sort(arr1);

        for(int i = 0; i< arr1.length ; i++){
            System.out.print(arr1[i] + " ");

        }


    }


}
