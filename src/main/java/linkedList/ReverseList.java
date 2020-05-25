package linkedList;

public class ReverseList {

    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
    public Node reverseList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = head;
        Node curr = head.next;
        Node nxt = head.next.next;

        while (curr!=null){
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if (nxt !=null) {
                nxt = nxt.next;
            }
        }

        head.next = null;
        return prev;

    }
}
