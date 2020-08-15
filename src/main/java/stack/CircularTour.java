package stack;

public class CircularTour {

//    https://leetcode.com/problems/gas-station/
//    https://practice.geeksforgeeks.org/problems/circular-tour/1

    public int canCompleteCircuit(int[] gas, int[] distance) {

        if(gas == null || distance == null || gas.length!= distance.length || gas.length == 0)         {
            return -1;
        }


        int n = gas.length;
        int start = 0;
        int end = 1;
        int reservoir = gas[start] - distance[start];

        if(gas.length == 1){
            if(reservoir >= 0){
                return start;
            }else return -1;
        }

        while( start!=end || reservoir < 0){


            while(start!=end && reservoir < 0){
                reservoir -= (gas[start] - distance[start]);
                start = (start + 1) % n;

                if(start == 0){
                    return -1;
                }
            }

            reservoir += (gas[end] - distance[end]);
            end = (end + 1) % n;
        }

        return start;

    }

}


