package com.company;

public class TonyHashset {
    private HashNode[] list;
    private int size;
    private int count;

    public  TonyHashset(int size) {
        this.size = size;
        this.list = new HashNode[size];
        this.count = 0;
    }

    private int hash(int val) {
        int hashVal = val;
//        hashVal = val.hashCode();
        hashVal %= this.size;
        return hashVal;
    }

    public boolean add(int val) {
        if (contains(val)) return false;
        int pos = hash(val);
        HashNode newNode = new HashNode(val);
        addHashNode(pos, newNode);
        count++;
        return true;
    }

    private void addHashNode(int pos, HashNode node) {
        if (this.list[pos] == null) {
            this.list[pos] = node;
            return;
        }
        node.next = this.list[pos];
        this.list[pos] = node;
    }

    public void clear(){
        this.list = new HashNode[this.size];
    }

    public boolean contains(int val) {
        int pos = hash(val);
        HashNode dummy = this.list[pos];
        while (dummy != null) {
            if (dummy.key == val) return true;
            dummy = dummy.next;
        }
        return false;
    }

    public void print() {
        System.out.println("-----------------------------------------");
        for (int i = 0; i < this.size; i++) {
            HashNode dummy = this.list[i];
            if (dummy == null) {
                System.out.println("List[" + i + "] == null.");
            } else {
                System.out.print("List[" + i + "] == ");
                while (dummy != null) {
                    System.out.print(dummy.key + " --> ");
                    dummy = dummy.next;
                }
                System.out.println("Done.");
            }
        }
        System.out.println("-----------------------------------------");
    }

    public boolean remove(int val) {
//        if (!contains(val)) {
//            System.out.println("Value " + val + " does not exist.");
//            return false;
//        }
        int pos = hash(val);
        HashNode dummy = new HashNode(0);
        dummy.next = this.list[pos];
        while (dummy.next != null) {
            if (dummy.next.key == val) {
                dummy.next = dummy.next.next;
                System.out.println("Remove val: " + val + ".");
                count--;
                return true;
            }
            dummy = dummy.next;
        }
        return false;
    }

    public int size(){
        return this.count;
    }
}
