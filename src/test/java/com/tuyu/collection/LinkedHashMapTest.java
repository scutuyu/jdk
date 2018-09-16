package com.tuyu.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author tuyu
 * @date 9/14/18
 * Talk is cheap, show me the code.
 */
public class LinkedHashMapTest {

    @Test
    public void testInsertOrder() {

        Map<String, Object> map = new LinkedHashMap<>();

        map.put("hello", "world");
        map.put("world", "hello");
        map.put("ty", "tuyu");

        map.get("world");

        System.out.println(map);
    }

    @Test
    public void testAccessOrder() {

        Map<String, Object> map = new LinkedHashMap<>(10, 0.75F, true);

        map.put("hello", "world");
        map.put("world", "hello");
        map.put("ty", "tuyu");

        map.get("world");
        map.put("ok", "okkk");
        map.get("hello");

        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void testView() {
        Map<String, Object> map = new LinkedHashMap<>(10, 0.75F, true);

        map.put("hello", "world");
        map.put("world", "hello");
        map.put("ty", "tuyu");

        Collection<Object> value1 = map.values();
        Collection<Object> value2 = map.values();
        System.out.println("value1 == value2 ? " + (value1 == value2));

        Set<String> key1 = map.keySet();
        Set<String> key2 = map.keySet();
        System.out.println("key1 == key2 ? " + (key1 == key2));

        Set<Map.Entry<String, Object>> entry1 = map.entrySet();
        Set<Map.Entry<String, Object>> entry2 = map.entrySet();
        System.out.println("entry1 == entry2 ? " + (entry1 == entry2));
    }
}
