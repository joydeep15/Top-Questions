package arrays;
/*
*
*Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge
* the two sorted arrays into one sorted array (in non-decreasing order).

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

Input: arr1[] = {10};
       arr2[] = {2, 3};
Output: arr1[] = {2}
        arr2[] = {3, 10}

Input: arr1[] = {1, 5, 9, 10, 15, 20};
       arr2[] = {2, 3, 8, 13};
Output: arr1[] = {1, 2, 3, 5, 8, 9}
        arr2[] = {10, 13, 15, 20}

2
4 5
1 3 5 7
0 2 6 8 9
2 3
10 12
5 18 20

Output:
0 1 2 3 5 6 7 8 9
5 10 12 18 20

*
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortedArrays {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        StringBuilder sb = new StringBuilder();
        while(t!=0){
            t--;
            String[] reader = bfr.readLine().split("\\s+");

            int[] arr0 = new int[Integer.parseInt(reader[0])];
            int[] arr1 = new int[Integer.parseInt(reader[1])];

            reader = bfr.readLine().split("\\s+");

            for(int i=0;i<reader.length ; i++){
                arr0[i] = Integer.parseInt(reader[i]);
            }

            reader = bfr.readLine().split("\\s+");

            for(int i=0;i<reader.length ; i++){
                arr1[i] = Integer.parseInt(reader[i]);
            }

            merge(arr0,arr1);

            for(int i=0;i<arr0.length; i++){
                sb.append(arr0[i]).append(" ");
            }


            for(int i=0;i<arr1.length; i++){
                sb.append(arr1[i]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void merge(int[] arr0, int[] arr1) {

        int l0 = arr0.length;
        int l1 = arr1.length;

        int gap = l0 + l1;
        gap = nextGap(gap);

        for( int i = gap; i > 0 ; i = nextGap(i) ){

            int j=0;
            int k=j+i;

            while( k < (l0+l1) ){

                if(k<l0){
                    // j and k both in arr0
                    if(arr0[j] > arr0[k]) {
                        swap(arr0, j, k);
                    }

                }else if( j < l0 ){
                    //j in arr0, k in arr1
                    if(arr0[j] > arr1[ k%l0 ]) {
                        int tmp = arr0[j];
                        arr0[j] = arr1[k % l0];
                        arr1[k % l0] = tmp;
                    }
                }else{
                    //both in arr1
                    if(arr1[j % l0 ] > arr1[k % l0]) {

                        swap(arr1,j % l0 ,k % l0 ); }
                }

                j++;
                k++;
            }


        }


    }

    private static void swap(int[] arr0, int j, int k) {

        int tmp = arr0[j];
        arr0[j] = arr0[k];
        arr0[k] = tmp;

    }

    private static int nextGap(int gap) {
        if(gap <=1)
            return 0;
        return  ((gap) / 2) + ((gap) % 2);
    }


}
