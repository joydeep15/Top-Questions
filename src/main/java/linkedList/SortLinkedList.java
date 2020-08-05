package linkedList;

public class SortLinkedList {

    public static Node mergeSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }


        Node middle = getMiddle(head);
        Node secondHead = middle.next;
        middle.next = null;

        Node leftHalf = mergeSort(head);
        Node rightHalf = mergeSort(secondHead);

        return MergeSortedListsIterative.mergeSortedLists(leftHalf, rightHalf);
    }

    private static Node getMiddle(Node head) {

        Node slow = head;
        Node fast = head.next;

        while (fast!=null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
