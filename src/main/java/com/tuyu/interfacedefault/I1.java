package com.tuyu.interfacedefault;

public interface I1 {

    // 接口中属性都是常量，
    public static final int age = 12;

    // 接口中不允许有静态代码块和代码块
//    static {
//        System.out.println("static block");
//    }
//
//    {
//        System.out.println("block");
//    }

    /** JDK8的接口中允许有静态方法，而之前版本不允许 */
    public static void hello() {
        System.out.println("hell");
    }

    /** JDK8的接口中允许有main方法 */
    public static void main(String[] args) {
        System.out.println("hello");
        int a = 10;
        int b = 20;
        int c = 29;
        System.out.println(a += 20 + 29);
    }

    /** 接口中不允许有构造函数 */
//    public I1(){
//
//    }

    // 子类在初始化之前，不许初始化父类，而子接口初始化的时候，不必初始化父接口，只有在使用到父接口时才初始化

    void test1();
    void test2();

    /** JDK8中允许接口中的方法有实现，但是方法前要加上defalut关键字 */
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

    @Override
    public void test3() {
        System.out.println("sss3");
    }

}
