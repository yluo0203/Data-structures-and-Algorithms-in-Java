package myQueue;

public class TonyArrayQueue implements TonyQueue{
    int maxSize;
    int size;
    int startPtr;
    int endPtr;
    int[] list;

    public TonyArrayQueue(int num) {
        this.maxSize = num;
        this.list = new int[num];
        this.size = 0;
        this.startPtr = 0;
        this.endPtr = -1;
    }
    public void add(int num) {
        if (isFull()) {
            System.out.println("*ArrayQueue is full.");
            return;
        }
//        if (isEmpty() && ) {
//            startPtr++;
//        }
        if (endPtr == maxSize - 1) {
            endPtr = 0;
        } else {
            endPtr++;
        }
        list[endPtr] = num;
        size++;
    }

    public int peek() {
        if (size == 0) return -1;
        return list[startPtr];
    }

    public int poll() {
        if (isEmpty()) {
            System.out.println("*ArrayQueue is empty.");
            return -1;
        }
        int result =list[startPtr];
        if (startPtr == maxSize - 1) {
            startPtr = 0;
        }else{
            startPtr++;
        }
        size--;
        return result;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void display() {
        int ptr = startPtr;
        int count = size;
        while (count > 0) {
            System.out.print( list[ptr] + " --> ");
            if (ptr == maxSize - 1) {
                ptr = 0;
            }else{
                ptr++;
            }
            count--;
        }
        System.out.println( " Done ");
    }

    public boolean isFull() {
        return size == maxSize;
    }

}
