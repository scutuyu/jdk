package com.tuyu.java8.typededuction;

/**
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class Value<T> {

    public static <T> T defaultValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

}
