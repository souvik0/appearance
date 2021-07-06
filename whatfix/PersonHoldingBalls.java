package com.whatfix;

import java.util.Stack;

public class PersonHoldingBalls {

	public static void main(String[] args) {
        int[] arr = {2, 1, 3, 7, 4};
        findOutPersonToTalk(arr);
    }

	public static void findOutPersonToTalk (int[] arr) {
        Stack<Integer> tempStack = new Stack<Integer>();
        tempStack.push(arr[0]);
        
        for (int i = 1 ; i<arr.length; i++) {
            while (!tempStack.isEmpty() && tempStack.peek() < arr[i]) {
                  System.out.println("Person having " + tempStack.pop() + "ball at" +i + "th location will talk to" +
                                     "next person at" +i + "location holding" +arr[i] + "no of balls" );
            }
            tempStack.push(arr[i]);
        }
        while (!tempStack.isEmpty()) {
            System.out.println("Person holding " +tempStack.pop() + "no of balls isn't communicate with anyone" );
        }
    }


}
