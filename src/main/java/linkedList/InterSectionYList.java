package linkedList;
//https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1/
/*

 */
public class InterSectionYList {

    int intersectPoint(Node headA, Node headB)
    {
        int leftLen = getLen(headA);
        int rightLen = getLen(headB);

        if (leftLen > rightLen) {
            int difference = leftLen - rightLen;
            return getIntersection(difference, headA, headB);
        } else {
            int difference = rightLen - leftLen;
            return getIntersection(difference, headB, headA);
        }
    }

    private int getIntersection(int difference, Node larger, Node smaller) {
        while (difference > 0) {
            if (larger == null) {
                return -1;
            }
            larger = larger.next;
            difference--;
        }

        while (larger != null && smaller != null) {
            if (larger == smaller) {
                return larger.data;
            }
        }
        return -1;
    }

    private int getLen(Node n) {
        Node node = n;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
