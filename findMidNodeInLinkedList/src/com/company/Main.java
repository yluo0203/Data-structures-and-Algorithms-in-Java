package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Node node = new Node();
        int[] myArray = {2, 3, 8, 16, 26, 28, 33, 36, 41, 66, 67, 68, 70, 71, 82, 86, 88, 90, 96, 97};
        node.createLinkedList(myArray);
        node.disply();
        System.out.println("Total elements: " + myArray.length + ", mid value: " + (findMid(node)) + " at index " + (myArray.length / 2 - 1));

    }

    private static int findMid(Node head){
        if (head == null) return -1;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
