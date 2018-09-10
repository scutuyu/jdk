package com.tuyu.enums;

import org.junit.Test;

/**
 * @author tuyu
 * @date 7/18/18
 * Stay Hungry, Stay Foolish.
 */
public class EnumsTest {

    @Test
    public void testEnums() {
        System.out.println(FruitEnum.APPLE);
    }

    @Test
    public void testValueOf() {
//        FruitEnum hello = FruitEnum.valueOf("hello");
//        System.out.println(hello);

        System.out.println(FruitEnum.APPLE.name());

        FruitEnum[] values = FruitEnum.values();
        for (FruitEnum f : values) {
            System.out.println(f);
        }
    }

    @Test
    public void testArea() {
//        AreaEnum ae = AreaEnum.CQ;
//        System.out.println(ae.name);
    }
}
