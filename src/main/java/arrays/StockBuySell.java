package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StockBuySell {

        public static void main(String[] args) throws IOException {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(bfr.readLine());
            StringBuilder sb = new StringBuilder();
            while (t != 0) {
                t--;
                int len = Integer.parseInt(bfr.readLine());
                String[] ele = bfr.readLine().split("\\s+");
                int[] elements = new int[len];

                for (int i = 0; i < len; i++) {
                    elements[i] = Integer.parseInt(ele[i]);
                }
                List<Pair<Integer>> ans = getFuture(elements);
                for( Pair<Integer> pair : ans ){
                    sb.append("(").append(pair.first).append(" ").append(pair.second).append(") ");
                }
                if(ans.size() == 0){
                    sb.append("No Profit");
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }

        public static List<Pair<Integer>> getFuture(int[] prices){

            int bp = 0, sp=0;
            List<Pair<Integer>> l = new ArrayList<>();
            for (int i = 0; i<prices.length ; i++){

                if(prices[i] > prices[sp] ){
                    //hodl
                    sp = i;
                }else{
                    //sell
                    if(prices[sp] > prices[bp]){
                        //profit
                        l.add(createPair(bp, sp));
                    }
                    bp = i;
                    sp = i;
                }
            }
            if(prices[sp] > prices[bp]){
                //profit
                l.add(createPair(bp, sp));
            }
            return l;
        }

    private static Pair<Integer> createPair(int bp, int sp) {
        Pair<Integer> p = new Pair<>();
        p.first = bp;
        p.second = sp;
        return p;
    }

    static class Pair<T>{
            T first;
            T second;
        }
}
