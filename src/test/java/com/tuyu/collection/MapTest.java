package com.tuyu.collection;

import org.junit.Test;
import org.omg.CORBA.MARSHAL;

import java.util.*;

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

    /**
     * 测试 当集合在迭代器构造之后发生改变，将抛出ConcurrentModificationException
     * <pre>
     *     覆盖值不是结构性修改，不会抛异常，
     *     添加或者删除才是结构性修改，才会抛异常
     * </pre>
     */
    @Test
    public void testConcurrentModificationException() {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
//        map.put("world", "tuyu");
        map.remove("hello");
        try {
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("添加或删除key、value之后，将抛出ConcurrentModificationException异常");
            e.printStackTrace();
        }
    }
}
