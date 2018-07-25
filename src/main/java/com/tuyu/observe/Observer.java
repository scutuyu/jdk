package com.tuyu.observe;

/**
 * 观察者接口
 *
 * @author tuyu
 * @date 7/25/18
 * Talk is cheap, show me the code.
 */
public interface Observer {

    void subscribe(Event event);
}
