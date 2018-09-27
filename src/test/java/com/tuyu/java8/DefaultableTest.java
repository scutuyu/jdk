package com.tuyu.java8;

import org.junit.Test;


/**
 * java8新特性，接口中可以声明默认方法和静态方法测试，
 * 这个特性，让Collection等接口中加入了大量的默认方法，如：stream,parallelStream等
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class DefaultableTest {

    @Test
    public void testJava8Interface() {
        Defaultable defaultable = DefaultableFactory.create(DefaultableImpl::new);
        System.out.println(defaultable.notRequired());

        defaultable = DefaultableFactory.create(OverridableImpl::new);
        System.out.println(defaultable.notRequired());
    }

}