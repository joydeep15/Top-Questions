package arrays;
/*
* Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DutchFlag {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bfr.readLine());
        StringBuilder sb = new StringBuilder();
        while (t!=0){
            t--;
            int count = Integer.parseInt(bfr.readLine());
            String[] items = bfr.readLine().split("\\s+");

            int[] elements = new int[items.length];

            for(int i=0;i<items.length;i++){
                elements[i] = Integer.parseInt(items[i]);
            }

            solve(elements);

            for(int i=0;i<elements.length;i++){
                sb.append(elements[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void solve(int[] elements) {

        int low = 0, mid = 0, high = elements.length - 1;

        while (mid <= high){

            if(elements[mid] == 0) {
                swap(low, mid, elements);
                low++;
                mid++;
            }else if(elements[mid] == 1){
                mid++;
            }else{
                swap(mid,high,elements);
                high--;
            }
        }
    }

    private static void swap(int idx1, int idx2, int[] elements) {
        int temp = elements[idx1];
        elements[idx1] = elements[idx2];
        elements[idx2] = temp;
    }
}
