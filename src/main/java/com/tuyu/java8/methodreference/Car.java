package com.tuyu.java8.methodreference;

import java.util.function.Supplier;

/**
 * 为了测试java8新特性：四种方法引用
 *
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class Car {

    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }

    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }

    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }
}
