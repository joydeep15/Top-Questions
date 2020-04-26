package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MinPlatforms {

    static class Train{
        int time =0;
        boolean arrival = false;
    }

    static class SortArrival implements Comparator<Train>{

        @Override
        public int compare(Train t1, Train t2) {
            return t1.time - t2.time;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t!=0){
            t--;

            int len = Integer.parseInt(bfr.readLine().trim());
            String[] aTime = bfr.readLine().split("\\s+");
            String[] dTime = bfr.readLine().split("\\s+");
            Train[] trains = new Train[len*2];

            for (int i = 0; i < len; i++) {
                Train train = new Train();
                train.time = Integer.parseInt(aTime[i]);
                train.arrival = true;
                trains[i] = train;
            }

            for (int i = len; i < len*2; i++) {
                Train train = new Train();
                train.time = Integer.parseInt(dTime[i-len]);
                train.arrival = false;
                trains[i] = train;
            }
            sb.append(minPlatforms(trains)).append("\n");
        }
        System.out.println(sb);

    }

    private static int minPlatforms(Train[] trains) {

        Arrays.sort(trains, new SortArrival());

        int max_count = 1;
        int curr_count = 0;
        int i = 0, j = 1;

        while (i < trains.length){

            if( trains[i].arrival )
                curr_count++;

            else
                curr_count--;

            max_count = Math.max(curr_count, max_count);
            i++;
        }

        return max_count;
    }
}
