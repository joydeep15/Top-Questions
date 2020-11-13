package DP;

import utilities.BReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinOperations {
//    https://practice.geeksforgeeks.org/problems/find-optimum-operation/0
    public static void main(String[] args) throws IOException {
        int t = BReader.getInteger();
        List<Integer> queryList = new ArrayList<>();

        while (t != 0) {
            t--;
            queryList.add(BReader.getInteger());
        }
        StringBuilder sb = new StringBuilder();
        queryList.forEach(c -> sb.append(getAns(c)).append("\n"));

        System.out.println(sb);

    }

    static int getAns(int x) {
        if (x < 3) {
            return x;
        }

        if (x % 2 == 0) {
            //even
            return 1 + getAns(x / 2);
        } else {
            return 1 + getAns(x - 1);
        }
    }

}
