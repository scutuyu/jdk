package com.tuyu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author tuyu
 * @date 8/8/18
 * Talk is cheap, show me the code.
 */
public class MyInvocationHandler implements InvocationHandler {

    private IHello iHello;

    public MyInvocationHandler(IHello iHello) {
        this.iHello = iHello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call " + method.getName());
        Object invoke = method.invoke(proxy, args);
        System.out.println("after call " + method.getName());
        return invoke;
    }
}
