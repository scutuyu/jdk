package com.tuyu.singleton;

import org.junit.Test;

/**
 * 单实例枚举实现Singleton
 * @author tuyu
 * @date 7/14/18
 * Stay Hungry, Stay Foolish.
 */
public class SingletonEnumTest {

    @Test
    public void test() {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        instance.setAge(12);
        instance.setName("tuyu");
        System.out.println(instance);

        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        System.out.println(instance1);

        System.out.println(instance == instance1);


        SingletonEnum instance2 = SingletonEnum.INSTANCE_2;
        System.out.println(instance2);
        instance2.setName("2tuyu");
        instance2.setAge(1222);
        System.out.println(instance2);

        SingletonEnum instance21 = SingletonEnum.INSTANCE_2;
        System.out.println(instance21);
        System.out.println(instance2 == instance21);

        System.out.println(instance == instance2);
    }
}
