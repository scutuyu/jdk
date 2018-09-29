package com.tuyu.java8.concurrency;

import org.junit.Test;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * java8新特性， 并发
 * @author tuyu
 * @date 9/28/18
 * Talk is cheap, show me the code.
 */
public class ConcurrentTest {


    @Test
    public void testConcurrentHashMap() {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
    }

    @Test
    public void testDoubleAccumulator() {
//        DoubleAccumulator accumulator = new DoubleAccumulator()
    }
}
