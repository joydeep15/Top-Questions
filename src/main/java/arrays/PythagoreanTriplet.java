package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PythagoreanTriplet {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        StringBuilder sb = new StringBuilder();
        while (t!=0){
            t--;
            int len = Integer.parseInt(bfr.readLine());
            String[] ele = bfr.readLine().split("\\s+");
            int[] elements = new int[len];

            for (int i = 0; i < len; i++) {
                elements[i] = Integer.parseInt(ele[i]);
            }

            if(hasTriplet(elements)){
                sb.append("Yes\n");
            }else{
                sb.append("No\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean hasTriplet(int[] elements) {

        for (int i = 0; i < elements.length; i++) {
            elements[i] = elements[i] * elements[i];
        }
        Arrays.sort(elements);
        //find a = b +c

        for (int i = elements.length - 1 ; i > -1; i--) {
            int target = elements[i];
            int l = 0;
            int r = i - 1;
            while(l < r ){
                int cur_sum = elements[l] + elements[r];
                if(cur_sum < target){
                    l++;
                }else if(cur_sum > target){
                    r--;
                } else return true;
            }
        }

        return false;

    }
}
