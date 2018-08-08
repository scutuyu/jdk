package com.tuyu.interfacedefault;

import org.junit.Test;

/**
 * @author tuyu
 * @date 8/3/18
 * Talk is cheap, show me the code.
 */
public class I1Test {
    @Test
    public void test() {
        I1 i1 = new C2();
        i1.test3();
        I1.hello();
        System.out.println(i1.toString("hello"));
    }
}
