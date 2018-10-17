package com.tuyu.abstrac;

/**
 * @author tuyu
 * @date 8/3/18
 * Talk is cheap, show me the code.
 */
public abstract class AbstractHello {

    private void hello() {
        System.out.println("hello world");
    }

    protected final void resolveClass() {
        System.out.println("resolve");
    }

    void myResolveClass() {

    }

    public void hi() {
        hello();
    }
}

class Hello extends AbstractHello {

    private String name;

    public String getName() {
        return name;
    }

//    protected final void resolveClass() {
//
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello tuyu");
    }
}