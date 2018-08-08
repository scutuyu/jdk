package com.tuyu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author tuyu
 * @date 8/7/18
 * Talk is cheap, show me the code.
 */
public class AopProxy extends Proxy {
    InvocationHandler handler;

    public AopProxy(InvocationHandler h) {
        super(h);
        handler = h;
    }

    public IHello create() {

        return null;
    }
}
