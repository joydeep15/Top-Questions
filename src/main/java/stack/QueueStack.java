package stack;

import java.util.LinkedList;
import java.util.Queue;

class QueuesStack
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    /*The method pop which return the element poped out of the stack*/
    int pop()
    {
        if (q2.isEmpty()) {
            return -1;
        }
        while (q2.size() != 1) {
            q1.add(q2.poll());
        }

        int retVal = q2.poll();

        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        return retVal;
    }

    /* The method push to push element into the stack */
    void push(int a)
    {
        q2.add(a);
    }
}