package com.tuyu.singleton;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * @author tuyu
 * @date 7/14/18
 * Stay Hungry, Stay Foolish.
 */
public class SingletonFieldTest {

    @Test
    public void test() {
        SingletonField instance = SingletonField.INSTANCE;
        instance.setName("tuyu");
        instance.setAge(12);
        System.out.println(instance);

        // 使用反射的方法来创建对象
        createSingleTwice(SingletonField.class, instance);


        // 测试反序列化后是否为同一个对象
        serialSingleton("singleton_field", instance);
    }

    public static void serialSingleton(String filename, Object singleton) {
        String file = "src/test/resources/" + filename;
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(singleton);
            objectOutputStream.close();

            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream(file));
            Object o = objectInputStream.readObject();
            System.out.println("反序列化之后，两个实例相等吗？ " + (o == singleton));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void createSingleTwice(Class clazz, Object singleton) {
        try {
            Constructor declaredConstructor = clazz.getDeclaredConstructor(new Class[]{});
            declaredConstructor.setAccessible(true);
            Object o = declaredConstructor.newInstance();
            System.out.println(o == singleton);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("反射创建对象失败");
            e.printStackTrace();
        }
    }
}