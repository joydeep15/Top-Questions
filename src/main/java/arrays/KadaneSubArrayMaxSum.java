package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KadaneSubArrayMaxSum {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        StringBuilder sb = new StringBuilder();
        while(t!=0){
            t--;
            int len =Integer.parseInt(bfr.readLine());
            int[] l = new int[len];
            String[] nos = bfr.readLine().split("\\s+");
            for (int i=0;i<len ; i++){
                l[i] = Integer.parseInt(nos[i]);
            }
            sb.append(kadane(l,len)).append("\n");
        }
        System.out.println(sb);
    }

    private static int kadane(int[] elements,int len) {

        int max_so_far = elements[0];
        int max_ending_here = elements[0];

        for(int i=1;i<len;i++){
            max_ending_here = Math.max(elements[i], elements[i] + max_ending_here);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;

    }

}
