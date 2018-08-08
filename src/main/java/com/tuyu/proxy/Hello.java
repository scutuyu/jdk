package com.tuyu.proxy;

/**
 * @author tuyu
 * @date 8/7/18
 * Talk is cheap, show me the code.
 */
public class Hello implements IHello {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
