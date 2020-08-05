package linkedList;

public class AddNumbers {

    public static Node addLists(Node first, Node second){

        first = reverseList(first);
        second = reverseList(second);

        if (length(first) > length(second)) {
            return reverseList(add(first, second));
        } else return reverseList(add(second, first));

    }

    private static Node add(Node first, Node second) {

        int carry = 0;
        Node ret = first;
        Node prev = null;
        while (second!=null) {
            int sum = carry + first.data + second.data;
            carry = sum / 10;
            first.data = sum%10;

            prev = first;
            first = first.next;
            second = second.next;
        }

        while (first != null) {
            int sum = carry + first.data;
            carry = sum / 10;
            first.data = sum % 10;
            prev = first;
            first = first.next;
        }

        if (first == null && carry > 0) {
            prev.next = new Node(carry);
        }
        return ret;
    }

    private static Node reverseList(Node first) {

        if (first == null || first.next == null) {
            return first;
        }
        Node prev = null;
        Node curr = first;
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

    private static int length(Node head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
