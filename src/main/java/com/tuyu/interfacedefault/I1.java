package com.tuyu.interfacedefault;

public interface I1 {

    public static void hello() {
        System.out.println("hell");
    }
    void test1();
    void test2();

    default String toString(String s) {
        return s;
    }


    default void test3(){
        System.out.println("sss1");
    }
}

interface I2 extends I1 {

    @Override
    default void test3(){
        System.out.println("sss2");
    }
}

class C2 implements I1, I2{


    @Override
    public void test1() {

    }

    @Override
    public void test2() {

    }

//    @Override
//    public void test3() {
//        System.out.println("sss3");
//    }

}
