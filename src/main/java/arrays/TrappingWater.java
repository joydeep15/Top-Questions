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

    private static int trappedWater(int[] blocks) {

        assert blocks.length > 2;
        int totalWater = 0;

        int i = 0, j = blocks.length - 1,lmax = -1, rmax = -1;

        while (i < j) {

            lmax = Math.max(lmax, blocks[i]);
            rmax = Math.max(rmax, blocks[j]);

            if(lmax > rmax){
                totalWater += rmax - blocks[j];
                j--;
            }else{

                totalWater += lmax - blocks[i];
                i++;
            }
        }

        return totalWater;



    }

}
