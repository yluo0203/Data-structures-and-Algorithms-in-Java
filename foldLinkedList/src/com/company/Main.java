package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myArray = {1, 3, 5, 7, 9, 11, 12, 10, 8, 6, 4, 2};
        Node head = new Node();
        head.createLinkedList(myArray);
        head.disply();
        Node foldHead = foldLinkedList(head);
        foldHead.disply();
    }

    private static Node foldLinkedList(Node head){
        if (head == null) return null;
        Node midNode = findMidNode(head);
        Node reversedHead = reverseLinkedList(midNode);
        Node mergeHead = merge(head, reversedHead);
        return mergeHead;
    }

    private static Node findMidNode(Node head) {
        if (head == null) return null;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("-------findMidNode-------");
        slow.disply();
//        return slow;
        return slow.next;
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
        System.out.println("-------reverseLinkedList-------");
        prev.disply();
        return prev;
    }

    private static Node merge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        System.out.println("-------merge-------");
        head1.disply();
        head2.disply();
        System.out.println("-------------------");

        Node dummy = head1;
        Node head = new Node();
        head.next = dummy;
        while(head1 != null && head2 != null) {
            head1 = head1.next;
            dummy.next = head2;
            head2 = head2.next;
            dummy = dummy.next;
            dummy.next = head1;
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;
    }
}
