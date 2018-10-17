package com.tuyu.initial;

/**
 * 《深入理解Java虚拟机》第7章
 * @author tuyu
 * @date 10/16/18
 * Talk is cheap, show me the code.
 */
public class NotInitialization {

    // 通过子类引用父类静态字段，不会触发子类的初始化
    // 也不会触发子类的加载，验证，准备操作
    // 通过SubClass.value访问父类的静态字段，
    // 只打印了父类初始化日志，并未打印子类初始化日志
    // 加上虚拟机参数：-XX:+TraceClassLoading，打印class加载日志
    // 只加载类NotInitialization和NotInitialization$SuperClass类
    private static void invokeParentStaticField() {
        System.out.println(SubClass.value);
    }

    // 通过数组定义来引用类，不会触发类的初始化
    // 通过-XX:+TraceClassLoading可以看到NotInitialization$SuperClass
    // 类被加载了，没有初始化
    private static void invokeArrayDefine() {
        // 类名[Lcom.tuyu.init.NotInitialization$SuperClass;
        SuperClass[] arr = new SuperClass[2];
        // 在加载子类之前，需要加载父类
//        SubClass[] arr = new SubClass[2];
//        System.out.println(arr.getClass().getName());
//        SuperClass[][] arrd = new SuperClass[2][3];
        // 类名[[Lcom.tuyu.init.NotInitialization$SuperClass;
//        System.out.println(arrd.getClass().getName());
    }

    // 调用常量，不会触发类的初始化
    // 常量在编译阶段会存入调用类的常量池，本质上没有直接调用定义常量的类
    private static void invokeConstValue() {
        // 常量传播优化，在编译期间已经被替换为了12
        System.out.println(ConstClass.value);
    }

    static class SuperClass{
        static {
            System.out.println("SuperClass initial");
        }

        public static int value = 10;
    }

    static class SubClass extends SuperClass{
        static {
            System.out.println("SubClass initial");
        }
    }

    static class ConstClass{
        static {
            System.out.println("ConstClass initial");
        }
        public static final int value = 12;
    }

     interface InnerInterface0{
        int A = 0;
        // 接口中不允许有静态代码块和代码块
//        static {
//            System.out.println();
//        }
    }

    interface InnerInterface1 extends InnerInterface0{
        int A = 1;
    }

    interface InnerInterface2 {
        // int A = 2;相当于public static final A = 2;
        int A = 2;
    }

    static class Parent implements InnerInterface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements InnerInterface2{
        // 注释类下面的代码，当访问Sub.A时，编译器拒绝编译，A是模棱两可的
        // 因为父类和接口中都A的定义
//        public static int A = 4;
    }

    // 通过虚拟机参数-Xverify:none关闭大部分类验证
    public static void main(String[] args) {
        // 如果一个对象强转为它并没有实现的类型，编译器拒绝编译
//        Object o = new Object();
//        InnerInterface subClass = (SubClass) o;

        System.out.println(Parent.A);
    }
}
