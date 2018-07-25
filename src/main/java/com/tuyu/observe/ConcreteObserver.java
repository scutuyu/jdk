package com.tuyu.observe;

/**
 * 具体的观察者
 *
 * @author tuyu
 * @date 7/25/18
 * Talk is cheap, show me the code.
 */
public class ConcreteObserver implements Observer {

    @Override
    public void subscribe(Event event) {
        System.out.println("观察到了事件： " + event);
    }
}
