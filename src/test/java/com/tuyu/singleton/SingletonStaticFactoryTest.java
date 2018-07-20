package com.tuyu.singleton;

import org.junit.Test;

import static com.tuyu.singleton.SingletonFieldTest.createSingleTwice;
import static com.tuyu.singleton.SingletonFieldTest.serialSingleton;
import static org.junit.Assert.*;

/**
 * @author tuyu
 * @date 7/14/18
 * Stay Hungry, Stay Foolish.
 */
public class SingletonStaticFactoryTest {


    @Test
    public void test() {
        SingletonStaticFactory instance = SingletonStaticFactory.getInstance();
        instance.setName("tuyu");
        instance.setAge(12);
        System.out.println(instance);

        SingletonStaticFactory instance1 = SingletonStaticFactory.getInstance();
        System.out.println(instance1);
        System.out.println("instance == instance1 ? " + (instance == instance1));

        // 使用反射的方法来创建对象
        createSingleTwice(SingletonField.class, instance);


        // 测试反序列化后是否为同一个对象
        serialSingleton("singleton_static_factory", instance);
    }
}