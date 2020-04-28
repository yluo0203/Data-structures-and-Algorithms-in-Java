package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myArray = {13, 88, 8, 21, 83, 93, 36, 3, 100};

        minStack stack = new minStack();

        for (int i = 0; i < myArray.length; i++){
            stack.push(myArray[i]);
        }
        stack.display();
        System.out.println(stack.findMinVal());
        System.out.println(stack.pop());
        System.out.println(stack.findMinVal());
        stack.display();

        for (int i = 0; i < 1; i++){
            stack.pop();
        }
        stack.display();


        for (int i = 0; i < 5; i++){
            stack.pop();
        }
        stack.display();

        for (int i = 0; i < 5; i++){
            stack.pop();
        }
        stack.display();
    }
}
