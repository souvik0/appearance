package com.oracle;

import java.util.*;

public class ImplementOwnStack {

    static Queue<Integer> queue = new LinkedList<Integer>();
    static Queue<Integer> tempQueue = new LinkedList<Integer>();

    public static void main(String[] args) {
        int element = 5;
        push(element);
    }

    public static void push(int element) {
        if (queue.isEmpty()) {
            queue.add(element); // O(1)
        } else {
            int sizeOfQueue = queue.size();

            for (int i = 0; i < sizeOfQueue; i++) {
                tempQueue.add(queue.poll());
            }
            queue.add(element);

            for (int j = 0; j < sizeOfQueue; j++) {
                queue.add(tempQueue.poll());
            }
        }
    }

    public static int pop() {
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return 0;
    }

    public static int peep() {
        if (!queue.isEmpty()) {
            return queue.element();
        }
        return 0;
    }

    // Consider this is different using the object of the own stack, just now ctreated
    public static int continuousPush(int element) {
        if (myOwnMinStack.isEmpty() && element < myOwnStack.peep()) {
            myOwnStack.push(element);
        }
        if (myOwnMaxStack.isEmpty() && element > myOwnStack.peep()) {
            myOwnStack.push(element);
        }
        myOwnStack.push(element); //Main stack
    }

    public static void continuousPop() {
        int poppedElement = myOwnStack.pop();

        if (myOwnMinStack.peep() == poppedElement) {
            myOwnMinStack.pop();
        }

        if (myOwnMaxStack.peep() == poppedElement) {
            myOwnMaxStack.pop();
        }
    }

    public static int getMin() {
       if ()
       return
    }
}
