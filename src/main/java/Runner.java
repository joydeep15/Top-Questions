import linkedList.MergeSortedListsIterative;
import linkedList.Node;

import java.io.*;
import java.util.List;

public class Runner {

    private static List<String> run;
    public static void main(String[] args) throws IOException {

        Node n = Node.createLinkedList(9,1000);
        Node m = Node.createLinkedList(10,100);
        n = MergeSortedListsIterative.mergeSortedLists(n, m);
//        List<Integer> l = Node.convertCollection(n, new LinkedList<>());
//        l.forEach(element -> {
//            System.out.print(element+"->");
//        });

        Node.printNodes(n);
    }

}
