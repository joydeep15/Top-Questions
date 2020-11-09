package linkedList;

public class OddEvenList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode tar = oddEvenList(head);
        System.out.println(tar);
    }

    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        boolean attachOdd = true;
        ListNode oddHead = head;
        ListNode oddTail = head;

        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;

        head = head.next;
        while (head != null) {

            if (attachOdd) {
                attachOdd = !attachOdd;
                head = head.next;
                oddTail.next = head;
                if (oddTail.next != null) {
                    oddTail = oddTail.next;
                }

            }else {
                attachOdd = !attachOdd;
                head = head.next;
                evenTail.next = head;
                if (evenTail.next != null) {
                    evenTail = evenTail.next;
                }
            }
        }
        oddTail.next = evenHead;
        return oddHead;
    }
}
