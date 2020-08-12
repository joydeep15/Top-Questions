package utilities;

public class DoublyLinkedList<T> {

    DLNode<T> head;
    DLNode<T> tail;
    int elementCount = 0;

    public DoublyLinkedList(T... items) {
      
       head= new DLNode<>(items[0]);
       DLNode<T> iterator = head;
        for (int i = 1; i < items.length ; i++) {
            DLNode<T> temp = new DLNode<>(items[i]);
            temp.prev = iterator;
            temp.next = null;

            iterator.next = temp;
            if (i == items.length - 1) {
                tail = temp;
            }
            iterator = iterator.next;
        }

        elementCount = items.length;
    }

    public DoublyLinkedList() {}

    /**
     * 
     * @param val value of the new node
     * @return the reference to the new node created
     */
    public DLNode<T> addFirst(T val) {
        
        DLNode<T> temp = new DLNode<>(val);
        if (head == null) {
            head = temp;
            tail = temp;
            elementCount++;
            return head;
        }

        temp.next = head;
        head = temp;
        elementCount++;
        return temp;
        
    }

    /**
     *
     * @param val value of the new node
     * @return the reference to the new node created
     */
    public DLNode<T> addLast(T val) {
        DLNode<T> temp = new DLNode<>(val);
        return addLast(temp);

    }

    public DLNode<T> addLast(DLNode<T> node) {
        if (tail == null) {
            head = node;
            tail = node;
            elementCount++;
            return head;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
        elementCount++;
        return node;
    }

    public int size() {
        return elementCount;
    }

    public void remove(DLNode<T> node) {
        //TODO check if node belongs to current dll
        if (elementCount == 1) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = head.next;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }

        node.next = null;
        node.prev = null;

        elementCount--;
    }

    public void removeFirst() {

        if (head == null) {
            return;
        }

        DLNode<T> oldHead = head;
        head = head.next;

        oldHead.next = null;
        oldHead.prev = null;

        elementCount--;

        if (elementCount == 0) {
            head = null;
            tail = null;
        }
    }

    public void removeLast() {
        if (tail == null) {
            return;
        }

        DLNode<T> oldTail = tail;
        if (tail.prev != null) {
            tail.prev.next = null;
        }

        tail = tail.prev;

        oldTail.prev = null;
        oldTail.next = null;

        elementCount--;

        if (elementCount == 0) {
            head = null;
            tail = null;
        }
    }

    public String printList() {
        StringBuilder sb = new StringBuilder();
        DLNode<T> traveller = head;
        while (traveller != null) {

            sb.append(traveller.val);
            if (traveller.next != null) {
                sb.append("->");
            }
            traveller = traveller.next;

        }
        return sb.toString();
    }


    public DLNode<T> getHead() {
        return this.head;
    }


    public DLNode<T> getTail() {
        return this.tail;
    }
    

}
