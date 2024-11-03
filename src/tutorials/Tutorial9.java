package tutorials;


import java.util.LinkedList;
import java.util.Queue;

public class Tutorial9 {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.toStr();
        System.out.println(myStack.peek());

        myStack.pop();
        myStack.pop();

        myStack.toStr();

        myStack.push(2);
        myStack.push(3);

        myStack.toStr();

        myStack.pop();
        myStack.pop();
        System.out.println(myStack.isEmpty());

        myStack.toStr();

//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);


    }


    //Stacks and Queues



    /*
    A stack is a data structure that follows the LIFO pattern where LIFO means Last in first out
    A stack data structure is commonly used in algorithms where we need to remember the past or a previously computed value.
    Can be implemented using arraylist, linkedList
    - Adding values to a stack
    - Access (get/find)
    - Traverse/Visit values in a stack

    A queue data structure is one that follows the FIFO pattern where FIFO means first in first out
    A queue data structure is commonly used in algorithms where you need to perform a wait or timer for resources  or computed values.
    Can be implemented using arraylist, linkedList, stacks
    - Adding values to a queue
    - Access (get/find)
    - Traverse/Visit values in a queue

    _ 5    topNode
    _ 4
    _ 3
    _ 2
    _ 1
    * */

}
