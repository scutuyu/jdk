package com.tuyu.equals;

import org.junit.Test;

/**
 * 测试equals
 *
 * @author tuyu
 * @date 7/17/18
 * Stay Hungry, Stay Foolish.
 */
public class EqualsTest {
    @Test
    public void testEquals() {
        Point point = new Point(1, 3);
        Object object = new Object();
        Point oo = (Point) object;
    }

    @Test
    public void testFloat() {
        float a = 8.0f;

        float b = 8.00f;
        float c = .75f;
        System.out.println(c);
        System.out.println(a == b);
    }
}
