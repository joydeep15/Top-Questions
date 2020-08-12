package linkedList;

public class Stack<I extends Number> {

    Node top;
    int elecount = 0;

    void push(int a) {

        Node tmp = new Node(a);
        if (elecount == 0) {
            top = tmp;
        } else {
            tmp.next = top;
            top = tmp;
        }

        elecount++;
    }


    int pop() {

        int val;
        if (elecount == 0) {
            return -1;
        } else if (elecount == 1) {
            val = top.data;
            top = null;
        } else {
            val = top.data;
            top = top.next;
        }

        return val;

    }
}
