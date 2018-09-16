package com.tuyu.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author tuyu
 * @date 9/13/18
 * Talk is cheap, show me the code.
 */
public class ConcurrentHashMapTest {


    public static void main(String[] args) {

        ConcurrentMap<String, Object> map = new ConcurrentHashMap<>(12, 0.74F, 12);
        map.put("hello", "world");
        map.get("hello");
        System.out.println(map);
        map.remove("hello");
        System.out.println(map);

    }

    @Test
    public void testResize() {
        System.out.println(Integer.numberOfLeadingZeros(32));
        System.out.println(Integer.numberOfLeadingZeros(1));
        System.out.println(Integer.numberOfTrailingZeros(32));
        System.out.println(Integer.numberOfTrailingZeros(1));
        int num = 8;
        int zeros = Integer.numberOfLeadingZeros(num);
        for (int i = 0; i < zeros; i++) {
            System.out.print(0);
        }
        System.out.println(Integer.toBinaryString(num));
    }

    @Test
    public void testList() {

        TreeMap<Node, Object> treeMap = new TreeMap<>();
    }

    static class Node{
        private String name;

        public Node(String name) {
            this.name = name;
        }
    }

    @Test
    public void testHash() {
        System.out.println(null instanceof String);
    }
}
