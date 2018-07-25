package com.tuyu.observe;

/**
 * @author tuyu
 * @date 7/25/18
 * Talk is cheap, show me the code.
 */
public abstract class Event {

    String name;
    String type;

    protected Event(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static final Event newEvent(String name, String type) {
        return new BasicEvent(name, type);
    }

    String getName() {
        return this.name;
    }

    String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
