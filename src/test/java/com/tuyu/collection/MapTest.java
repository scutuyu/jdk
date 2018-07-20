package com.tuyu.collection;

import org.junit.Test;
import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * map测试类
 *
 * @author tuyu
 * @date 7/14/18
 * Stay Hungry, Stay Foolish.
 */
public class MapTest {
    /**
     * Map.keySet()
     */
    @Test
    public void testKeySet() {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        map.put("world", "hello");
        map.put("show", "time");

        Set<String> set = map.keySet();

        System.out.println(set);

        map.remove("world");

        Set<String> set1 = map.keySet();

        System.out.println(set1);

        System.out.println("set == set1 ? " + (set == set1));
    }
}
