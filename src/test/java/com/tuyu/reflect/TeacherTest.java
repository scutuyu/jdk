package com.tuyu.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 父类没有无参构造函数，子类能否通过反射生成实例
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class TeacherTest {

    @Test
    public void test() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Teacher.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            int count = constructor.getParameterCount();
//            System.out.println(count);
            Class[] parameterTypes = constructor.getParameterTypes();
            System.out.println("" + count + Arrays.toString(parameterTypes));
            Object tuyu = constructor.newInstance("tuyu");
            System.out.println(tuyu);
        }

    }
}