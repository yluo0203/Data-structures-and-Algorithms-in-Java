package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TonyHashset mySet = new TonyHashset(7);
        mySet.print();
        mySet.add(1);
        mySet.add(8);
        mySet.add(15);

        mySet.add(5);
        mySet.add(12);

        mySet.print();
        mySet.remove(8);
        mySet.print();

        mySet.clear();
        mySet.print();

//        for (int i = 0; i < 1000; i++) {
//            int num = (int)(Math.random() * 100 * Math.random());
//            mySet.add(num);
//        }
//        mySet.print();
    }
}
