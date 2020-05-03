package com.company;

public class TonyQueue {
    private int maxSize;
    private int size;
    private Node[] list;

    public TonyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.list = new Node[maxSize];
    }

    public int peek(){
        if (size == 0) return -1;
        return list[size - 1].val;
    }

    public int size(){
        return size;
    }

    public int poll() {
        if (size == 0) return -1;
        int top = list[0].val;
        list[0].val = list[size - 1].val;
        size--;
        trickleDown();
        return top;
    }

    public boolean add(int num) {
        if (size == maxSize) return false;
        list[size] = new Node(num);
        size++;
        trickleUp();
        return true;
    }

    private void trickleUp() {
        int node = list[size - 1].val;
        int cur = size - 1;
        while (cur > 0) {
            int prev = (cur - 1) / 2;
            if (list[prev].val > node) {
                list[cur].val = list[prev].val;
            } else {
                break;
            }
            cur = prev;
        }
        list[cur].val = node;
    }

    private void trickleDown() {
        int node = list[0].val;
        int cur = 0;
        while (cur < (size - 1) / 2) {
            int left = 2 * cur + 1;
            int right = 2 * cur + 2;
            int next;

            if (list[left].val < list[right].val) {
                next = left;
            } else {
                next = right;
            }
            if (list[next].val < node) {
                list[cur].val = list[next].val;
            } else {
                break;
            }
            cur = next;
        }
        list[cur].val = node;
    }

    public void display(){
        System.out.print("myQueue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(list[i].val + " --> ");
        }
        System.out.println("Done. ");
    }

}
