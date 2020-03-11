import sorting.QuickSort;
import utilities.Graph;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
//
//        Graph<Integer> graph = new Graph<>();
//        graph.addEdge(0, 1, false);
//        graph.addEdge(0, 2, false);
//        graph.addEdge(0, 3, false);
//        graph.addEdge(3, 5, false);
//        graph.addEdge(2, 4, false);
//        graph.addEdge(2, 1, false);
//
//        System.out.println(graph.toString());

        int[] arr = {9,7,8,7,6,2,5,1};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
