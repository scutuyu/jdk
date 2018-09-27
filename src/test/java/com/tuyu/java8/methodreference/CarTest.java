package com.tuyu.java8.methodreference;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 测试java8的四种方法引用
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class CarTest {

    @Test
    public void testMethodReference() {
        // 构造器应用，无参构造器
        Car car = Car.create(Car::new);

        List<Car> list = Arrays.asList(car);

        // 静态方法引用
        list.forEach(Car::collide);

        // 特定类的对象的方法引用
        list.forEach(Car::repair);

        // 特定对象的方法引用
        list.forEach(car::follow);
    }

}