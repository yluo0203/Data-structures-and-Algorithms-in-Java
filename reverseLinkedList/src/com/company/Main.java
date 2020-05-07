package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myArray= {2, 3, 8, 16, 26, 28, 33, 36, 41, 66, 67, 68, 70, 71, 82, 86, 88, 90, 96, 97};
        Node head = new Node();
        head.createLinkedList(myArray);
        Node reverseHead = reverseLinkedList(head);
        reverseHead.disply();
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null) return null;
        Node prev = null;

        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
