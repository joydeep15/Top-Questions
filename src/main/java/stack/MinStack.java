package stack;

import java.util.Stack;

public class MinStack {
//    https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1

    int minEle;
    Stack<Integer> s = new Stack<>();


    /*returns min element from stack*/
    int getMin()
    {
        if (s.size() == 0) {
            return -1;
        } else return minEle;
    }

    /*returns poped element from stack*/
    int pop()
    {
        if (s.size() == 0) {
            return -1;
        }
        if (s.peek() > minEle) {
            return s.pop();
        } else {
            int retVal = minEle;
            s.pop();
            minEle = 2 * minEle - retVal;
            return retVal;
        }
    }

    /*push element x into the stack*/
    void push(int x)
    {
        if (s.size() == 0) {
            s.push(x);
            minEle = x ;
        } else if (x > s.peek()) {
            s.push(x);
        } else {
            minEle = x;
            s.push(2 * x - minEle);
        }


    }

}
