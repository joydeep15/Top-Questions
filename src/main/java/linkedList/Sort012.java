package linkedList;

public class Sort012 {
    //https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

    public static Node segregate(Node head)
    {
        //move zeroes
        Node traveller = head;
        Node prev = null;
        Node tail = getTail(head);
        int NodeCount = getCount(head);

        while (traveller != null && NodeCount>0) {
            NodeCount--;
            if (traveller.data == 0 && traveller!=head) {
                Node tmp = traveller.next;
                prev.next = tmp; //detach node

                head = addToHead(head,traveller);
                traveller = tmp;
                continue;
            } else if (traveller.data == 2) {

                Node tmp = traveller.next;
                if (prev == null) {
                    //head node is 2
                    head = head.next;
                } else {
                    prev.next = tmp;
                }
                tail = addToTail(tail, traveller);
                traveller = tmp;
                continue;

            }
            prev = traveller;
            traveller = traveller.next;
        }

        return head;
    }

    private static int getCount(Node head) {
        int i=0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }

    private static Node addToTail(Node tail, Node traveller) {
        tail.next = traveller;
        traveller.next = null;
        return traveller;
    }

    private static Node getTail(Node head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    private static Node addToHead(Node head, Node traveller) {

        traveller.next = head;
        return traveller;
    }

}
