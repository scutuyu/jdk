package com.tuyu.java8.functional;

/**
 * 注解@FunctionalInterface函数式注解
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
@FunctionalInterface
public interface FunctionalDefaultMethods {

    void method();

    default void defaultMethod() {
    }
}
