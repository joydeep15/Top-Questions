package linkedList;

public class RotateList {

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
