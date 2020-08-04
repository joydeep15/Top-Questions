package linkedList;

public class NthNodeFromEnd {
//    https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1

    // Function to find the nth node from end in the linked list
    // head: head of the linked list
    // n: nth node from end to find
    int getNthFromLast(Node head, int n)
    {
        if (head == null) {
            return -1;
        }
        Node fast = head;

        while (n != 0) {
            n--;
            if (fast != null) {
                fast = fast.next;
            }else break;
        }
        if (n > 0) {
            return -1;
        }

        while (fast != null) {
            fast = fast.next;
            head = head.next;
        }
        return head.data;
    }
}


