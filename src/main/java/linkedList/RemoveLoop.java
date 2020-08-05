package linkedList;

public class RemoveLoop {
//    https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
    public static void removeLoop(Node head){

        Node intersectionPoint = getIntersection(head);
        if (intersectionPoint == null) {
            return;
        }

        removeLoop(head, intersectionPoint);

}

    /**
     * Intersection point is the result of the cycle detection algorithm(Floyd's)
     * if we are here, we are sure that the loop exists
     * @param head
     * @param intersectionPoint
     */
    private static void removeLoop(Node head, Node intersectionPoint) {


        Node traveller = head;

        if (intersectionPoint == head) {
            //entire LL is a cycle
            while (traveller.next != head) {
                traveller = traveller.next;
            }
            traveller.next = null;
            return;
        }
        while (traveller.next !=  intersectionPoint.next ){
            traveller = traveller.next;
            intersectionPoint = intersectionPoint.next;
        }
        intersectionPoint.next = null;
    }

    /**
     *  Return null if there is no intersection between the hare
     *  and the tortoise. Returns intersection point if present;
     * @param head
     * @return
     */
    private static Node getIntersection(Node head) {
        Node hare = head;
        Node tortoise = head;

        while (hare != null) {
            if (tortoise.next != null) {
                tortoise = tortoise.next;
            }

            hare = hare.next;

            if (hare != null) {
                hare = hare.next;
            }

            if(hare == tortoise)
                return hare;
        }
        return null;
    }
}
