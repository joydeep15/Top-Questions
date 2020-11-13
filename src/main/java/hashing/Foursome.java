package hashing;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Foursome {

    public static void main(String[] args) {

        int[] arr = {0, 0, 2, 1, 1,};
        Set<Integer> set = new HashSet<>();
        fourSum(arr, 4).forEach(f->{
            f.forEach(s -> System.out.print(s + " "));
            System.out.println();
        });

    }
    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {

        Set<ArrayList<Integer>> result = new LinkedHashSet<>();

        if(arr==null || arr.length < 4){
            return null;
        }

        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0; i < n - 3 ; i++ ){
            for(int j=i+1 ; j < n - 2 ; j++ ){

                int l = j+1;
                int r = n-1;

                while( l < r ){
                    int sum = arr[i] + arr[j] + arr[l] + arr[r];
                    if( sum == k){
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(arr[i]);
                        tmp.add(arr[j]);
                        tmp.add(arr[l]);
                        tmp.add(arr[r]);
                        if(!result.contains(tmp))
                            result.add(tmp);
                        l++;
                        r--;
                    }else if( sum < k){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
