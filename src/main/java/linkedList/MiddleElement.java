package linkedList;

public class MiddleElement {

    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }

    class Solution
    {
        // Function to find middle element a linked list
        int getMiddle(Node head)
        {
            if (head == null) {
                return 0;
            }
            if(head.next == null){
                return head.data;
            }

            Node mid = head;
            Node curr = head.next;
            while (curr!=null){
                mid = mid.next;
                curr = curr.next;
                if (curr != null) {
                    curr = curr.next;
                }
            }

            return mid.data;
        }
    }
}
