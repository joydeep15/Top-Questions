package prefixSum;

import org.junit.Assert;
import org.junit.Test;

public class FlipStringToMonotoneIncreasing {

    @Test
    public void testMonotone(){
        FlipStringToMonotoneIncreasing sol = new FlipStringToMonotoneIncreasing();
        String query = "00011000";
        Assert.assertEquals(2, sol.minFlipsMonoIncr(query));
    }


    public int minFlipsMonoIncr(String s) {

        if(s==null || s.length() <= 1){
            return 0;
        }


        int[] prefix = new int[s.length()+1];
        int sum=0;
        prefix[0]=0;
        for(int i = 0; i < s.length(); i++){
            sum += s.charAt(i) == '1' ? 1 : 0;
            prefix[i+1] = sum;
        }

        int answer = Integer.MAX_VALUE;
        for(int zeros = 0; zeros <= s.length(); zeros++){

            //cost of switching to x 0's and y 1's
            //1. convert all 1's to the left of x to zeros = P[x]
            //2. convert all 0's in the right side of x to 1 = (P[n] - P[x])
            int cost = prefix[zeros] +
                    (s.length() - zeros) - (prefix[s.length()] - prefix[zeros]);
            // System.out.println(cost);
            answer = Math.min(cost, answer);
        }

        return answer;

    }


}
