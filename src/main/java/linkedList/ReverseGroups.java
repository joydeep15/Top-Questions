package linkedList;

import java.util.Scanner;

/**
 * Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.
 *
 * Input:
 * First line of input contains number of testcases T. For each testcase, first line contains length of linked list and next line contains the linked list elements.
 *
 * Output:
 * For each testcase, there will be a single line of output which contains the linked list with every k group elements reversed.
 *
 * User Task:
 * The task is to complete the function reverse() which should reverse the linked list in group of size k.
 *
 * Expected Time Complexity : O(n)
 * Expected Auxilliary Space : O(1)
 *
 * Example:
 * Input:
 * 2
 * 8
 * 1 2 2 4 5 6 7 8
 * 4
 * 5
 * 1 2 3 4 5
 * 3
 *
 * Output:
 * 4 2 2 1 8 7 6 5
 * 3 2 1 5 4
 *
 * Explanation:
 * Testcase 1: Since, k = 4. So, we have to reverse everty group of two elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.
 */

public class ReverseGroups {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Node head = LinkedListHelper.createLinkedListFromUserInput(sc);
        int k = sc.nextInt();
        ReverseGroups rg = new ReverseGroups();
        head = rg.reverse(head, k);
        LinkedListHelper.printList(head);

    }

    static class Pair<T>{
        T first;
        T second;
    }

    public static Node reverse(Node node, int k)
    {
        assert k > 0;
        if(k<2){
            return node;
        }

        Pair<Node> pp = reverseK(node, k);
        Node retVal = pp.first;

        Pair<Node> Npp;

        while(pp.second != null){
            Npp = reverseK(pp.second.next, k);
            pp.second.next = Npp.first;
            pp = Npp;
        }
        return retVal;
    }
    private static Pair<Node> reverseK(Node head, int k) {

        if (head == null ) {
            return new Pair<>();
        }

        if (head.next == null) {
            Pair<Node> p = new Pair<>();
            p.first = head;
            p.second = null;
            return p;
        }

        Node prev = head;
        Node curr = head.next;
        Node after = head.next.next;
        Node oldHead = head;

        while (k > 1 && curr != null) {
            k--;
            curr.next = prev;
            prev = curr;
            curr = after;

            if (after != null) {
                after = after.next;
            }
        }

        oldHead.next = curr;
        Pair<Node> pp = new Pair<>();

        pp.first = prev; //head of new LL
        pp.second = oldHead;// last node with K reversed
        return pp;

    }

}

