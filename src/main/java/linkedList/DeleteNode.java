package linkedList;

public class DeleteNode {

    //assuming its not the tail node
    public static void deleteNode(Node node)
    {
        if (node == null) {
            return;
        }


        Node detached = node.next;

        if (detached != null) {
            node.next = detached.next;
            node.data = detached.data;
        }


    }
}
