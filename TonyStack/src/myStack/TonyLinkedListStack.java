package myStack;

public class TonyLinkedListStack implements TonyStack {
    private int count;
    private ListNode top;


    public TonyLinkedListStack() {
        this.count = -1;
        this.top = null;
    }

    private class ListNode{
        int value;
        ListNode prev;

        public ListNode(int num) {
            this.value = num;
            this.prev = null;
        }
    }

    public void push(int num) {
        ListNode newNode = new ListNode(num);
        count++;
        if (top == null) {
            top = newNode;
        }else{
            newNode.prev = top;
            top = newNode;
        }

    }

    public int pop(){
        if (top == null) {
            return -1;
        }
        count--;
        int result = top.value;
        top = top.prev;
        return result;
    }

    public int peep() {
        return top.value;
    }

    public int getSize(){
        return count;
    }

    public boolean isEmpty(){
        return count == -1;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display(){
        ListNode ptr = top;
        while (ptr != null) {
            System.out.print(ptr.value + " --> ");
            ptr = ptr.prev;
        }
        System.out.print(" Done. ");
    }
}
