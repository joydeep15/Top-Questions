package linkedList;

import java.util.List;
import java.util.Objects;

public class Node {
    int data;
    Node next;
    Node bottom;
    Node(int d)  { data = d;  next = null; bottom = null; }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    public static void printNodes(Node h){
        while (h != null) {
            System.out.print(h.data+"->");
            h=h.next;
        }
        System.out.print("null\n");

    }

    public static Node createLinkedList(int... nums) {
        if (nums.length < 1) {
            return null;
        }

        Node head = new Node(nums[0]);
        Node traveller = head;
        for (int i = 1; i < nums.length ; i++) {
            traveller.next = new Node(nums[i]);
            traveller = traveller.next;
        }

        return head;
    }

    public static  List<Integer> convertCollection(Node h, List<Integer> x) {

        while (h != null) {
            x.add(h.data);
            h = h.next;
        }
        return x;
    }
}