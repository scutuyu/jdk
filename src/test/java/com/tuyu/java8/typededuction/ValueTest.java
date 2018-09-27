package com.tuyu.java8.typededuction;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * java8新特性，更强的类型推导
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class ValueTest {

    @Test
    public void testTypeDeduction() {
        Value<String> value = new Value<>();
        // java7的写法: value.getOrDefault("22", Value.<String>defaultValue());
        String newValue = value.getOrDefault("22", Value.defaultValue());
        System.out.println(newValue);
    }
}