package linkedList;

public class ReverseList {

    public static Node reverseList(Node head) {


        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }
}
