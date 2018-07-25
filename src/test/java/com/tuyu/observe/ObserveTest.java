package com.tuyu.observe;

import org.junit.Test;

/**
 * 观察者模式测试
 *
 * @author tuyu
 * @date 7/25/18
 * Talk is cheap, show me the code.
 */
public class ObserveTest {

    @Test
    public void testObserve() {
        Observer observer = new ConcreteObserver();
        Subject subject = new ConcreteSubject();
        subject.register(observer);
        Event event = Event.newEvent("下班了", "0");
        subject.notice(event);

        subject.unregister(observer);
        subject.notice(event);
    }
}
