package arrays;

import java.util.*;

public class SubArrayWithGivenSum {
    static List<Integer> inputList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t!=0){
             t--;
            int len = in.nextInt();
            int target = in.nextInt();
            inputList.clear();
            for(int i=0; i< len ;i++){
                inputList.add(in.nextInt());
            }
            printSubArrayWithGivenSum(inputList, target);
        }
    }

    private static void printSubArrayWithGivenSum(List<Integer> inputList, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int cumulative_sum = 0;
        int start = 0;
        int end = 0;

        for(int i=0; i < inputList.size() ; i++){

            cumulative_sum += inputList.get(i);
            if(cumulative_sum == target){
                //answer is 0,i
                start = 1;
                end = i + 1;
                System.out.println( start+" "+end );
                return;
            }

            if(map.containsKey(cumulative_sum - target)){

                start = map.get(cumulative_sum-target) +1+1;
                end = i+1;
                System.out.println( start+" "+end );
                return;
            }

            map.put(cumulative_sum, i);
        }

        System.out.println(-1);

    }
}
