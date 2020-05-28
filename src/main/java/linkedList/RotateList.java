package linkedList;


public class RotateList {
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    public Node rotate(Node head, int k) {
        Node iterator = head;
        k--;
        while (k>0 && iterator!=null ){
            k--;
            iterator = iterator.next;
        }
        if(k!=0 || iterator == null || iterator.next == null){
            return head;
        }

        Node nHead = iterator.next;
        iterator.next = null;
        iterator = nHead;

        while (iterator.next != null) {
            iterator = iterator.next;
        }

        iterator.next = head;
        return nHead;

    }
}
