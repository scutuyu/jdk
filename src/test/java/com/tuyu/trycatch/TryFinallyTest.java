package com.tuyu.trycatch;

import org.junit.Test;

/**
 * @author tuyu
 * @date 8/3/18
 * Talk is cheap, show me the code.
 */
public class TryFinallyTest {

    @Test
    public void testReturn() {
        System.out.println(getNum());

    }

    // try中将返回的字节码指令放入操作栈中，再执行finally，如果修改变量，对之前的操作不影响，如果是return，就会直接返回
    private int getNum() {
        int hello = 1;
        try {
            hello = 2;
            return hello;
        } finally {
//            return 2;
            hello = 3;
        }
    }
}
