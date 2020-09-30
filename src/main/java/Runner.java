import backtracking.NQueens;
import utilities.Graph;
import utilities.ResourceReader;
import utilities.URLDecode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicReference;

public class Runner {
    public static int compare(Integer o1, Integer o2) {
        return o2-o1;
    }

    public static void main(String[] args) {

        PriorityQueue<Integer> p = new PriorityQueue<Integer>((a,b) -> b-a){{
            add(1);
            add(257);
            add(-12);
        }};

        while (!p.isEmpty()) {
            System.out.println(p.poll());
        }


    }
}
