package myStack;

public class TonyArrayStack implements TonyStack{
    private int maxSize;
    private int count;
    private int[] list;

    public TonyArrayStack(int capacity) {
        this.count = -1;
        this.maxSize = capacity;
        this.list = new int[capacity];
    }

    public void push(int num) {
        if (!isFull()) {
            count += 1;
            list[count] = num;
        }else{
            System.out.println("Stack is Full.");
        }
    }

    public int pop(){
        int val = list[count];
        count -= 1;
        return val;
    }

    public void display(){
        for (int i = 0; i <= count; i++) {
            System.out.print(list[i] + " --> ");
        }
        System.out.println(" Done ");
    }

    public int peep() {
        return list[count];
    }

    public int getSize(){
        return count + 1;
    }
    public boolean isEmpty(){
        return count == -1;
    }
    public boolean isFull(){
        return count == maxSize - 1;
    }
}



