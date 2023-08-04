package com.pangw.st;


import lombok.Getter;

class A {
    @Getter
    private int val;

    public A(){
        System.out.println("new a");
        setVal(5);
    }
    public void setVal(int val){
        System.out.println("a.setVal");
        this.val = val;
    }
    public int getVal(){
        System.out.println("a.getVal");
        try{
            this.val++;
            System.out.println(val);
            return val;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            System.out.println(val);
        }
    }

}
