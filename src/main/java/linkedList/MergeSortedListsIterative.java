package linkedList;

public class MergeSortedListsIterative {

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
