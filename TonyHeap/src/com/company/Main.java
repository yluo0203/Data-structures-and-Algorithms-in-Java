package com.company;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        TonyQueue myQueue = new TonyQueue(10);
        myQueue.add(5);
        myQueue.add(25);
        myQueue.add(15);
        myQueue.add(10);
        myQueue.add(35);
        myQueue.add(3);
        myQueue.add(27);
        myQueue.display();
        myQueue.poll();
        myQueue.display();
        myQueue.poll();
        myQueue.display();
        myQueue.poll();
        myQueue.display();
        myQueue.poll();
        myQueue.display();
        myQueue.poll();
        myQueue.display();
        myQueue.add(37);
        myQueue.add(15);
        myQueue.display();
        myQueue.poll();
        myQueue.display();
    }
}
