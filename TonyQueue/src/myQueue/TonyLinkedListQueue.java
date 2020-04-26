package myQueue;

import javax.management.ListenerNotFoundException;
import java.util.LinkedList;

public class TonyLinkedListQueue implements TonyQueue{
    int count;
    LinkedNode head;
    LinkedNode tail;

    class LinkedNode{
        int value;
        LinkedNode next;

        private LinkedNode(int num) {
            this.value = num;
            this.next = null;
        }
    }

    public TonyLinkedListQueue() {
        this.count = -1;
        this.head = null;
        this.tail = null;
    }

    public void add(int num) {
        LinkedNode newNode = new LinkedNode(num);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }
    public int peek() {
        if (isEmpty()) return -1;
        return head.value;
    }

    public int poll() {
        if (isEmpty()) return -1;
        int result = peek();
        head = head.next;
        count--;
        return result;
    }

    public int getSize() {
        return count + 1;
    }

    public boolean isEmpty() {
        return count == -1;
    }

    public void display() {
        LinkedNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.value + " --> ");
            ptr = ptr.next;
        }
        System.out.println(" Done. ");
    }
}
