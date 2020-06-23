package linkedList;

import java.util.Scanner;

public class LinkedListHelper {

    /**
     * Input Format:
     * 6
     * 1 2 3 4 5 6
     * creates ll = 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * @param sc Scanner for user input
     * @return head of LinkedList
     */
    public static Node createLinkedListFromUserInput(Scanner sc) {


            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
        return head;
    }


    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
