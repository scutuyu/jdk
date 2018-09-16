package com.tuyu.initial;

/**
 * 测试类的初始化顺序和实例化顺序
 *
 * <pre>
 *     jad -p com/tuyu/initial/Father.class反编译的结果：
 *     // Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
 *     // Jad home page: http://www.kpdus.com/jad.html
 *     // Decompiler options: packimports(3)
 *     // Source File Name:   Father.java
 *
 *     package com.tuyu.initial;
 *
 *     import java.io.PrintStream;
 *
 *     public class Father
 *     {
 *         private static class B extends A
 *         {
 *
 *             private static int sb = 12;
 *             private int b;
 *
 *             static
 *             {
 *                 System.out.println("b static block");
 *             }
 *
 *             public B()
 *             {
 *                 b = 10;
 *                 System.out.println("b non-static block");
 *                 System.out.println("b constructor");
 *             }
 *         }
 *
 *         private static class A
 *         {
 *
 *             private static int sa = 12;
 *             private int a;
 *
 *             static
 *             {
 *                 System.out.println("a static block");
 *             }
 *
 *             public A()
 *             {
 *                 a = 10;
 *                 System.out.println("a non-static block");
 *                 System.out.println("a constructor");
 *             }
 *         }
 *
 * </pre>
 * @author tuyu
 * @date 9/12/18
 * Talk is cheap, show me the code.
 */
public class Father {


   private static class A {
       private static int sa = 12;
       private int a = 10;
       static {
           System.out.println("a static block");
       }
       {
           System.out.println("a non-static block");
       }

       public A() {
           System.out.println("a constructor");
       }
   }

    private static class B extends A {
        private static int sb = 12;
        private int b = getB();

        private int getB(){
            System.out.println("initial b");
            return 10;
        }
        static {
            System.out.println("b static block");
        }
        {
            System.out.println("b non-static block");
        }

        public B() {
            System.out.println("b constructor");
        }
    }

    public static void main(String[] args) {
        System.out.println(highestOneBit(13));
        System.out.println(tableSizeFor(13));
    }
    public static int highestOneBit(int i) {
        i |= (i >>  1);
        i |= (i >>  2);
        i |= (i >>  4);
        i |= (i >>  8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }

    static final int tableSizeFor(int cap) {
       int MAXIMUM_CAPACITY = 1 << 30;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
