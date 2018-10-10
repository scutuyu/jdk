package com.tuyu.autobox;

import org.junit.Test;

/**
 * @author tuyu
 * @date 10/10/18
 * Talk is cheap, show me the code.
 */
public class AutoBoxTest {

    @Test
    public void testAutoBoxing() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 321L;
        Long i = 321L;
        // 缓存，同一对象
        System.out.println(c == d);
        // 没有缓存，不同对象
        System.out.println(e == f);
        // 自动装箱，缓存，同一对象
        System.out.println(c == (a + b));
        // 比较值，相等
        System.out.println(c.equals(a + b));
        // 自动装箱为Long类型，缓存，同一对象
        System.out.println(g == (a + b));
        // 比较值，自动装箱
        System.out.println(g.equals(a + b + 0L));
        System.out.println(h == i);
        System.out.println(g == (1 + 2));
        System.out.println(g == (1 + 2L));
        System.out.println(h == (1 + 322L));
    }
}
