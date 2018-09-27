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

    public void hi() {
        hello();
    }
}

class Hello extends AbstractHello {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello tuyu");
    }
}