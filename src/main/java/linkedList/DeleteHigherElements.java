package linkedList;

import java.util.Map;

public class DeleteHigherElements {

    public static void main(String[] args) {

        LinkedList list = new LinkedList( 20, 12, 10, 15, 6, 2, 5, 30);
        deleteLargerRight(list);
        System.out.println(list);
    }

    private static void deleteLargerRight(LinkedList list) {

        list.reverse();
        if (list.head == null) {
            return;
        }

        int maxVal = list.head.data;
        Node traveller = list.head.next;
        Node prev = list.head;

        while (traveller != null) {

            maxVal = Math.max(maxVal, traveller.data);
            if (traveller.data < maxVal) {
                Node next = traveller.next;
                list.deleteNode(prev, traveller);
                traveller = next;
                continue;
            }

            prev = traveller;
            traveller = traveller.next;
        }

        list.reverse();
    }
}
