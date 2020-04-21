package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeadersArray {
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

            sb.append(solve(elements)).append("\n");
        }

        System.out.println(sb);
    }

    private static String solve(int[] items) {

        int curr_max = items[items.length - 1];

        for (int i = items.length - 1; i > -1; i--) {

            if(items[i] >= curr_max){
                curr_max = items[i];
            }else{
                items[i] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            if(items[i]==-1)
                continue;
            sb.append(items[i] + " ");
        }

        return sb.toString();
    }
}
