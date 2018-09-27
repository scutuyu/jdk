package com.tuyu.exception;

import org.junit.Test;

/**
 * @author tuyu
 * @date 9/19/18
 * Talk is cheap, show me the code.
 */
public class MyExceptionTest {

    @Test
    public void testMyRunTimeException() {
        throwRunTimeException();
    }

    @Test
    public void testMyCheckedException() {
        try {
            throwCheckedException();
        } catch (MyCheckedException e) {
            e.printStackTrace();
        }
    }

    private void throwRunTimeException() {
        System.out.println("下面将要抛出继承自Error类的运行时异常");
        throw new MyRunTimeException();
    }

    private void throwCheckedException() throws MyCheckedException {
        throw new MyCheckedException();
    }
}
