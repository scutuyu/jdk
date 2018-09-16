package com.tuyu.abstrac;

import java.lang.reflect.Method;

/**
 * @author tuyu
 * @date 9/15/18
 * Talk is cheap, show me the code.
 */
public interface MyInterface {
     static void hello(){
         System.out.println("static method MyInterface");
     }

    static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("com.tuyu.abstrac.MyInterface");
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println();
    }
}

class Node implements MyInterface {
}