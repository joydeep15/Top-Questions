package linkedList;

public class CheckPalindrome {
//https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1

    // Function to check if linked list is palindrome
    public static boolean isPalindrome(Node head)
    {
        if (head == null || head.next == null) {
            return true;
        }

        //split ll
        Node slow = head;
        Node fast = head.next;
        Node midPrev = null;
        while (fast!=null && fast.next != null) {
            midPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        Node head2 = null;

        if (fast == null) {
            //odd list
            midPrev.next = null;
            head2 = slow.next;
            
        }else {
            //even list 
            head2 = slow.next;
            slow.next = null;

        }

        head2 = reverse(head2);

        while (head != null && head2 != null) {
            if (head.data != head2.data) {
                return false;
            }

            head = head.next;
            head2 = head2.next;
        }

        if (head == null && head2 == null) {
            return true;
        }
        return false;
    }

    private static Node reverse(Node head) {

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
