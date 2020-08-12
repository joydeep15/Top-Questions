package stack;


import java.util.Stack;

class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /* The method insert to push element
       into the queue */
    void Push(int x)
    {
        s2.push(x);
    }


    /* The method remove which return the
      element popped out of the queue*/
    int Pop()
    {

        if (s1.isEmpty() && s2.isEmpty()) {
            return -1;
        }

        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        return s1.pop();
    }
}
