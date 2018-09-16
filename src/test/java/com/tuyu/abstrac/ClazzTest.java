package com.tuyu.abstrac;

import org.junit.Test;

/**
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class ClazzTest {
//    static {
//        System.out.println("static block");
//    }
//    {
//        System.out.println("non-static block");
//    }

    /**
     * 静态内部类的表示方式:xx.xx.OuterClassName$InnerClassName
     * @throws ClassNotFoundException
     */
    @Test
    public void testInitial() throws ClassNotFoundException {
        String name = "com.tuyu.abstrac.ClazzTest$Node$Inner";
//        Class.forName(name, true, ClassLoader.getSystemClassLoader());
        ClassLoader classLoader = ClazzTest.this.getClass().getClassLoader();
        classLoader.loadClass(name);

    }

    static class Node{
        static {
            System.out.println("Node static block");
        }

        {
            System.out.println("Node non-static block");
        }
        static class Inner{
            static {
                System.out.println("Inner static block");
            }
            {
                System.out.println("Inner non-static block");
            }
        }
    }
}
