package com.tuyu.observe;

/**
 * 被观察者接口
 *
 * @author tuyu
 * @date 7/25/18
 * Talk is cheap, show me the code.
 */
public interface Subject {

    boolean register(Observer observer);

    boolean unregister(Observer observer);

    void notice(Event event);
}
