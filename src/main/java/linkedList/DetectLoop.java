package linkedList;

public class DetectLoop {
    public int detectLoop(Node head) {
        if (head == null) {
            return 0;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            if (slow == fast) {
                return 1;
            }
        }

        return 0;

    }
}
