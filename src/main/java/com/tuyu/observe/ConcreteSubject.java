package com.tuyu.observe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 具体的被观察者
 *
 * @author tuyu
 * @date 7/25/18
 * Talk is cheap, show me the code.
 */
public class ConcreteSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();


    @Override
    public boolean register(Observer observer) {
        boolean add = observers.add(observer);
        if (add) {
            observer.subscribe(Event.newEvent("注册", "2"));
        }
        return add;
    }

    @Override
    public boolean unregister(Observer observer) {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(observer)) {
                iterator.remove();
                observer.subscribe(Event.newEvent("注销", "1"));
                break;
            }
        }
        return true;
    }

    @Override
    public void notice(Event event) {
        for (Observer observer : observers) {
            observer.subscribe(event);
        }
    }
}
