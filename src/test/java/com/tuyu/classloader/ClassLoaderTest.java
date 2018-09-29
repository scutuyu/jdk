package com.tuyu.classloader;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author tuyu
 * @date 9/28/18
 * Talk is cheap, show me the code.
 */
public class ClassLoaderTest {
    @Test
    public void testParent() throws SQLException {
        Class<ClassLoaderTest> clazz = ClassLoaderTest.class;
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(clazz.getSimpleName() + "类的类加载器是: "
                + classLoader.getClass().getName());

        ClassLoader parent = classLoader.getParent();
        System.out.println(classLoader.getClass().getSimpleName()
                + "类的类加载器是: "
                + parent.getClass().getName());

        ClassLoader parentParent = parent.getParent();
        Optional<ClassLoader> optional = Optional.ofNullable(parentParent);
        System.out.println(parent.getClass().getSimpleName()
                + "类的类加载器的是: "
                + optional.map(s -> s.getClass().getName())
                .orElse("null"));

        Thread.currentThread().setContextClassLoader(new MyClassLoader());
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader.getClass().getName());

        Connection hello = DriverManager.getConnection("hello");

    }
    static class MyClassLoader extends ClassLoader{

    }

}
