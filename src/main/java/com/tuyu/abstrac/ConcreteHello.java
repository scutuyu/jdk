package com.tuyu.abstrac;

/**
 * ConcreteHello继承abstrac包下的没有访问修饰符的类Hello
 * @author tuyu
 * @date 9/19/18
 * Talk is cheap, show me the code.
 */
public class ConcreteHello extends Hello {

    public void set() {
        super.setName("tuyu");
    }

    public void print() {
        System.out.println(super.getName());
    }

    public static void main(String[] args) {
        ConcreteHello concreteHello = new ConcreteHello();
        concreteHello.set();
        concreteHello.print();
    }
}
