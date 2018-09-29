package com.tuyu.java8.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * java8新特性，Optional测试
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class OptionalTest {

    @Test
    public void testNull() {
        // ofNullable静态工厂，允许值为空
        Optional<String> name = Optional.ofNullable(null);
        printName(name);
        // of静态工厂，不允许值为空
        name = Optional.of("Tom");
        printName(name);
    }

    private void printName(Optional<String> name) {
        System.out.println("name is present ? " + name.isPresent());
        System.out.println("name = " + name.orElseGet(() -> "[none]"));
        System.out.println(name.map(s -> "Hey " + s + " !").orElse("Hey Stranger !"));
    }
}
