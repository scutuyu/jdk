package com.tuyu.methodhandle;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 方法句柄测试
 * @author tuyu
 * @date 10/16/18
 * Talk is cheap, show me the code.
 */
public class MethodHandleTest {

    @Test
    public void testMthodHandle() throws Throwable {

        // 1. 通过静态工厂构造MethodType实例
        MethodType methodType1 = MethodType.methodType(void.class);
        MethodType methodType2 = MethodType.methodType(int.class, String.class);
        MethodType methodType3 = MethodType.methodType(String.class);

        // 2. 通过工具类查找指定类的指定方法并生成MethodHandle实例，需要传入MethodType实例
        MethodHandle methodHandle1 = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "f1", methodType1);
        MethodHandle methodHandle2 = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "f2", methodType2);
        MethodHandle methodHandle3 = MethodHandles.lookup().findStatic(MethodHandleTest.class, "f3", methodType3);

        // 3. 调用MethodHandle实例的invoke方法，可能需要传入指定对象或者参数
        methodHandle1.invoke(this);
        int lenth = (int) methodHandle2.invoke(this, "tuyu");
        String s = (String) methodHandle3.invoke();
        System.out.println(lenth);
        System.out.println(s);
    }

    private void f1() {
        System.out.println("f1");
    }

    private int f2(String name) {
        return name.length();
    }

    private static String f3() {
        return "f3";
    }
}
