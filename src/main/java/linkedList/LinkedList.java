package linkedList;

public class LinkedList {

    Node head;
    int size;

    public LinkedList(int... nums) {

        if (nums.length < 1) {
            this.head = null;
            return;
        }

        Node head = new Node(nums[0]);
        Node traveller = head;
        for (int i = 1; i < nums.length ; i++) {
            traveller.next = new Node(nums[i]);
            traveller = traveller.next;
        }

        this.head = head;
        this.size = nums.length;
    }

    public int getSize() {
        return size;
    }

    public void deleteNode(Node prev, Node toDelete){

        if (toDelete == head) {
            head = head.next;
            size--;
            return;
        }

        prev.next = toDelete.next;
        toDelete.next = null;
        size--;
    }

    @Override
    public String toString() {
        return head.toString();
    }

    public void reverse() {


        if (head == null || head.next == null) {
            return;
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

        this.head = prev;
    }
}
