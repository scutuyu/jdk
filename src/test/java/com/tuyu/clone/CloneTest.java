package com.tuyu.clone;

import org.junit.Test;

/**
 * 测试clone方法，实现Cloneable接口与不实现Cloneable接口的区别
 * @author tuyu
 * @date 7/18/18
 * Stay Hungry, Stay Foolish.
 */
public class CloneTest {

    /**
     *<pre>
     *     如果一个类覆盖了Object的clone方法而没有实现Cloneable接口，当调用clone方法的时候将会报CloneNotSupportedException；
     *     如果要正确使用clone方法，就需要实现Cloneable接口，并覆盖Object的clone方法
     *</pre>
     * @throws CloneNotSupportedException
     */
    @Test
    public void testClone() throws CloneNotSupportedException {
        PersonImplCloneable personImplCloneable = new PersonImplCloneable();
        personImplCloneable.setName("ty");
        personImplCloneable.setAge(12);
        System.out.println("personImplCloneable： " + personImplCloneable);
        Object clone = personImplCloneable.clone();
        System.out.println("clone object: " + clone);

        PersonNotImplCloneable personNotImplCloneable = new PersonNotImplCloneable();
        personNotImplCloneable.setName("tuyu");
        personNotImplCloneable.setAge(11);
        System.out.println("personNotImplCloneable: " + personNotImplCloneable);
        Object clone1 = personNotImplCloneable.clone();
        System.out.println("clone object:" + clone1);
    }
}
