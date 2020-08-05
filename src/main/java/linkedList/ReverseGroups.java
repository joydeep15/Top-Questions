package linkedList;


/**
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 */


class LinkedLi{
    Node head;
    Node tail;
    Node nextHead;

    LinkedLi(Node head, Node tail, Node nextHead) {
        this.head = head;
        this.tail = tail;
        this.nextHead = nextHead;
    }
    LinkedLi(){}
}
public class ReverseGroups {

    public static Node  reverse(Node head, int k)
    {
        if (k < 2 || head.next == null) {
            return head;
        }

        LinkedLi intermediate = Kreverse(head, k);
        Node retval = intermediate.head;

        while (intermediate.nextHead != null) {
            LinkedLi nintermediate = Kreverse(intermediate.nextHead, k);
            intermediate.tail.next = nintermediate.head;
            intermediate = nintermediate;
        }

        return retval;
    }

    private static LinkedLi Kreverse(Node head, int k) {

        if (k < 2 || head.next == null) {
            return new LinkedLi(head, head, null);
        }

        Node prev = null;
        Node curr = head;
        Node next = head.next;

        LinkedLi retVal = new LinkedLi();
        retVal.tail = curr;

        while (curr != null && k != 0) {
            k--;
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null)
                next = next.next;
        }

        retVal.head = prev;
        retVal.nextHead = curr;
        return retVal;

    }
}

