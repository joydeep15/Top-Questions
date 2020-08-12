package utilities;

public class DLNode<T> {
        T val;
        DLNode<T> next;
        DLNode<T> prev;

        DLNode(T val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }

    public T getVal() {
        return this.val;
    }
}
