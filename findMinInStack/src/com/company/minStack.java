package com.company;

import java.util.Stack;

public class minStack {
    private class Node {
        int minVal;
        int NodeIndex;

        Node(int val, int index){
            this.minVal = val;
            this.NodeIndex = index;
        }
    }

    private int index;
    private Stack<Integer> mainStack;
    private Stack<Node> list;

    public minStack() {
        this.list = new Stack();
        this.mainStack = new Stack();
        this.index = -1;
    }

    public void push(int num) {
        mainStack.push(num);
        index++;
        if(list.isEmpty()){
            list.push(new Node(num, 0));
            return;
        }
        Node topNode = list.pop();
        if (topNode.minVal > num) {
            list.push(topNode);
            list.push((new Node(num, index)));
        }else{
            list.push(topNode);
        }
    }

    public int pop() {
        if (mainStack.isEmpty()) return -1;
        int val = mainStack.pop();
        Node topNode = list.pop();
        if (topNode.NodeIndex < index) {
            list.push(topNode);
        }
        index--;
        return val;
    }

    public int peep() {
        if (mainStack.isEmpty()) return -1;
        return mainStack.peek();
    }

    public boolean isEmpty(){
        return mainStack.isEmpty();
    }

    public int findMinVal(){
        if (isEmpty()) {
            return -1;
        }
        Node topNode = list.pop();
        list.push(topNode);
        return topNode.minVal;
    }

    public void display(){
        System.out.print("MainStack: ");
        for (int i = 0; i <= index; i++) {
            System.out.print(mainStack.get(i) + " --> ");
        }
        System.out.println("Done.");

        System.out.print("List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print("<" + list.get(i).minVal + ", " + list.get(i).NodeIndex + "> --> ");
        }
        System.out.println("Done.");
    }
}
