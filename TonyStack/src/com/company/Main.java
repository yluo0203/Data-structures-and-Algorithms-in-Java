package com.company;

import myStack.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TonyStack stack = new TonyArrayStack(3);
        System.out.println("Implement a stack using singly Array");
        System.out.println(stack.isEmpty()); // true
        stack.push(10);
        System.out.println(stack.isEmpty()); // false
        stack.push(20);
        System.out.println(stack.peep()); // 20
        System.out.println(stack.isFull()); // false
        stack.push(30);
        System.out.println(stack.peep()); // 30
        System.out.println(stack.isFull()); // true
        stack.push(40);
        System.out.println(stack.pop()); // 30
        System.out.println(stack.peep()); // 20
        System.out.println(stack.getSize()); // 2
        stack.display();
        System.out.println(" ");

        System.out.println("Implement a stack using singly linked list.");
        TonyStack stack2 = new TonyLinkedListStack();
        System.out.println(stack2.isEmpty()); // true
        stack2.push(10);
        System.out.println(stack2.isEmpty()); // false
        stack2.push(20);
        System.out.println(stack2.peep()); // 20
        stack2.push(30);
        System.out.println(stack2.peep()); // 30
        System.out.println(stack2.pop()); // 30
        System.out.println(stack2.peep()); // 20
        System.out.println(stack2.getSize()); // 20
        stack2.display();


    }
}

//    void push();
//    int pop();
//    int peep();
//    int getSize();
//    boolean isEmpty();
//    boolean isFull();