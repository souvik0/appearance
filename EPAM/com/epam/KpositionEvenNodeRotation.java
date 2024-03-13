package com.epam;

public class KpositionEvenNodeRotation {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        Node head = one;

        Node newHead = rotateEvenValueNodesFromRearEnd(head, 2);
        // print new linkedlist node values
    }

    private static Node rotateEvenValueNodesFromRearEnd(Node head, int k) {
            Node fast = null;
            Node slow = null;

            // Reaching upto middle node
            while (fast != null & fast.next != null) {
                 slow = slow.next;
                 fast = fast.next.next;
            }
    }
}
