package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] myArray= {2, 3, 8, 16, 26, 28, 33, 36, 41, 66, 67, 68, 70, 71, 82, 86, 88, 90, 96, 97};
        Node head = new Node();
        head.createLinkedList(myArray);
        head.disply();
        Node reverseHead = recursionReverse(head);
        reverseHead.disply();
    }

//    ref: https://www.geeksforgeeks.org/reverse-a-linked-list/
    private static Node recursionReverse(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = recursionReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}













//    private static Node recursionReverse(Node head) {
//        if (head == null || head.next == null) return head;
//        Node nextNode = recursionReverse(head.next);
//        head.next.next = head;
//        head.next = null;
//        return nextNode;
//
//    }