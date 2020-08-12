package stack;

import java.util.Stack;

public class MinStack {
//    https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1

    int minEle;
    Stack<Integer> s = new Stack<>();


    /*returns min element from stack*/
    public int getMin()
    {
        if (s.size() == 0) {
            return -1;
        } else return minEle;
    }

    /*returns poped element from stack*/
    public int pop()
    {
        if (s.size() == 0) {
            return -1;
        }
        if (s.peek() > minEle) {
            return s.pop();
        } else {
            int retVal = minEle;
            minEle = 2 * minEle - s.peek();
            s.pop();
            return retVal;
        }
    }

    /*push element x into the stack*/
    public void push(int x)
    {
        if (s.size() == 0) {
            s.push(x);
            minEle = x ;
        } else if (x > minEle) {
            s.push(x);
        } else {
            s.push(2 * x - minEle);
            minEle = x;
        }

    }

}
