package linkedList;

class MyQueue
{
    Node front, rear;
    int eleCount = 0;

    // This function should add an item at
    // rear
    void push(int a)
    {
        Node newNode = new Node(a);
        if (eleCount == 0) {
            front = newNode;
            rear = newNode;

        }else{
            rear.next = newNode;
            rear = newNode;
        }

        eleCount++;
    }

    // This function should remove front
    // item from queue and should return
    // the removed item.
    int pop()
    {

        int val;

        if (eleCount == 0) {
            return -1;
        } else if (eleCount == 1) {

            val = front.data;
            front = null;
            rear = null;

        }else{
            val = front.data;
            front = front.next;
        }

        eleCount--;
        return val;
    }
}