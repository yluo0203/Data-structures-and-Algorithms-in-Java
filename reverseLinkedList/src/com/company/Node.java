package com.company;

public class Node {
    int val;
    Node next;

    public Node() {
        this.val = -1;
        this.next = null;
    }

    public Node(int num) {
        this.val = num;
        this.next = null;
    }

    public void recursiveDisplay(Node head){
        if (head == null) {
            System.out.println(" Done. ");
            return;
        }
        System.out.print(head.val + " --> ");
        recursiveDisplay(head.next);
    }

    public void iterativeDisplay() {
        Node head = new Node(this.val); // --???

        while (head != null) {
            System.out.print(head.val + " --> ");
            head = head.next;
        }
        System.out.println(" Done.");
    }

    public void createLinkedList(int[] arr){
        if (arr == null || arr.length == 0) return;
        this.val = arr[0];
        Node dummy = new Node(arr[1]);
        Node nextNode = dummy;
        for (int i = 2; i < arr.length; i++) {
            dummy.next = new Node(arr[i]);
            dummy = dummy.next;
        }
        this.next = nextNode;
    }

    public void createCircledLinkedList(int[] arr){
        if (arr == null || arr.length == 0) return;
        this.val = arr[0];
        Node dummy = new Node(arr[1]);
        Node nextNode = dummy;
        for (int i = 2; i < arr.length; i++) {
            dummy.next = new Node(arr[i]);
            dummy = dummy.next;
        }
        dummy.next = nextNode;
        this.next = nextNode;
    }

    public void disply(){
        if (this.next == null) {
            System.out.println(this.val + " --> Done.");
            return;
        }
        Node dummy = this.next;
        System.out.print(this.val + " --> ");
        int lock = 50;
        while (dummy != null && lock >= 0){
            if (lock == 0){
                System.out.println("Force break the loop.");
            }
            lock--;

            System.out.print(dummy.val + " --> ");
            dummy = dummy.next;
        }
        System.out.println(" Done. ");
    }
}