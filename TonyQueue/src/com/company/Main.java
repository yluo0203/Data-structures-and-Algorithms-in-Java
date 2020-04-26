package com.company;

import myQueue.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Implement queue using linked list.");
        TonyQueue queue1 = new TonyLinkedListQueue();
        testQueue(queue1);

        System.out.println("");

        System.out.println("Implement queue using array.");
        TonyQueue queue2 = new TonyArrayQueue(5);
        testQueue(queue2);

    }

    public static void testQueue(TonyQueue queue1) {
        System.out.println(queue1.isEmpty()); // true
        queue1.add(10);
        System.out.println(queue1.isEmpty()); // false
        System.out.println(queue1.peek()); // 10
        queue1.add(20);
        queue1.add(30);
        queue1.add(40);
        queue1.add(50);
        queue1.add(60);
        queue1.add(70);
        queue1.display();
                // 10 --> 20 --> 30 --> 40 --> 50 --> 60 --> 70 -->  Done.
                // 10 --> 20 --> 30 --> 40 --> 50 -->  Done
        System.out.println(queue1.poll()); // 10
        System.out.println(queue1.poll()); // 20
        System.out.println(queue1.poll()); // 30
        System.out.println(queue1.poll()); // 40
        queue1.display();
            // 50 --> 60 --> 70 -->  Done.
            // 50 -->  Done
        System.out.println(queue1.poll()); // 50
        System.out.println(queue1.peek()); // 60 / -1
        System.out.println(queue1.poll()); // 60 / -1
        System.out.println(queue1.poll()); // 70 / -1
        System.out.println(queue1.peek()); // -1 / -1
        queue1.add(10);
        queue1.add(20);
        queue1.add(30);
        queue1.add(40);
        queue1.add(50);
        queue1.add(60);
        queue1.add(70);
        queue1.display();
            // 10 --> 20 --> 30 --> 40 --> 50 --> 60 --> 70 -->  Done.
            // 10 --> 20 --> 30 --> 40 --> 50 -->  Done
        System.out.println(queue1.getSize()); // 7 / 5
        queue1.display();
    }
}
