package linkedList;

public class UnionFind {

    public static Node findUnion(Node head1,Node head2)
    {
        //lets join both the lists first
        if(head1 == null){
            return head2;
        }

        if(head2 == null){
            return head1;
        }

        Node nhead1=head1;
        while(nhead1.next!=null)
            nhead1= nhead1.next;

        nhead1.next=head2;
        //sort the lists
        head1 = mergeSort(head1);

        //remove duplicates
        removeDuplicates(head1);
        return head1;
    }

    public static void removeDuplicates(Node head){
        Node prev = head;
        Node curr = head.next;

        while(curr!=null){

            if(prev.data == curr.data){
                while(curr!=null && prev.data == curr.data){
                    curr=curr.next;
                }
                prev.next=curr;
            }else{
                prev = prev.next;
                curr = curr.next;

            }
        }
    }
    public static Node mergeSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }


        Node middle = getMiddle(head);
        Node secondHead = middle.next;
        middle.next = null;

        Node leftHalf = mergeSort(head);
        Node rightHalf = mergeSort(secondHead);

        return mergeSortedLists(leftHalf, rightHalf);
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

    public static Node mergeSortedLists(Node list1, Node list2) {


        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }else {
            if (list1.data < list2.data) {
                return merge(list1, list2);
            }else{
                return merge(list2, list1);
            }
        }


    }

    private static Node merge(Node list1, Node list2) {

        Node fptr = list1;
        Node sptr = list2;
        Node fnext = fptr.next;
        Node snext = sptr.next;

        while (true) {

            if (sptr == null) {
                return list1;
            }

            while (fnext != null && fnext.data < sptr.data) {
                fptr = fptr.next;
                fnext = fptr.next;
            }

            if(fnext == null){
                fptr.next = sptr;
                return list1;
            }

            // fnext > sptr

            fptr.next = sptr;
            sptr.next = fnext;

            sptr = snext;
            if (sptr != null) {
                snext = sptr.next;
            }
            fnext = fptr.next;

        }
    }

}
