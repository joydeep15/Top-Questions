package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingWater {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        StringBuilder sb = new StringBuilder();

        while (t != 0) {
            t--;
            int len = Integer.parseInt(bfr.readLine());
            String[] elements = bfr.readLine().split("\\s+");
            int[] blocks = new int[len];

            for (int i = 0; i < len; i++) {
                blocks[i] = Integer.parseInt(elements[i]);
            }

            sb.append(trappedWater(blocks)).append("\n");
        }
        System.out.print(sb);
    }

    private static int trappedWater(int[] height) {

        if(height == null || height.length == 0){
            return 0;
        }

        int lmax = height[0];
        int rmax = height[height.length - 1];

        int left = 0;
        int right = height.length - 1;
        int water = 0;

        while(left < right){

            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);

            if(lmax <= rmax){

                // the answer at A[i] will be lmax
                // this is because even though rmax continues to increase,
                // we are limited by the lmax value which is present at this
                // point
                water += lmax - height[left];
                left++;
            }else{
                //the converse is true here
                water += rmax - height[right];
                right--;
            }
        }
        return water;
    }

}
