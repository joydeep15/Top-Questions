package linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FlattenLinkedList {

    //https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1

    Node flatten(Node root)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>(5, (o1, o2) -> {
            if (o1.data < o2.data) {
                return -1;
            } else if (o1.data == o2.data) {
                return 0;
            }else return 1;

        });
        Node ref=null;
        Node returnRef=null;
        while (root != null) {
            pq.add(root);
            root = root.next;
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Node lowest = pq.poll();

            if(lowest.bottom!=null)
                pq.add(lowest.bottom);

            if (ref == null) {
                ref = lowest;
                returnRef = ref;
                ref.next = null;
                ref.bottom=null;
            }else {
                ref.bottom = lowest;
                ref.next = null;
                ref=ref.bottom;
            }
        }
        return returnRef;
    }
}
