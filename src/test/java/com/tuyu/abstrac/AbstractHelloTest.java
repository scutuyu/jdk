package com.tuyu.abstrac;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tuyu
 * @date 8/3/18
 * Talk is cheap, show me the code.
 */
public class AbstractHelloTest {

    @Test
    public void test() {
        Hello hello = new Hello();
        hello.hello();
        hello.hi();
    }
}