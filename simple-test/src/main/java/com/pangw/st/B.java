package com.pangw.st;

public class B extends A {
    int val;


    public B() {
        System.out.println("new b");
    }

    public void setVal(int val) {
        System.out.println("b.setVal");
        super.setVal(2 * val);
    }

//    public int getVal(){
//        System.out.println("b.getVal");
//        return val;
//    }
}
