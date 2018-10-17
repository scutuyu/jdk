package com.tuyu.foreeach;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author tuyu
 * @date 10/15/18
 * Talk is cheap, show me the code.
 */
public class Foreach {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>(2);
        list.add(new Node("tuyu"));
        list.add(new Node("ty"));
        for (Node node : list) {
            System.out.println(node);
        }

        Node[] arr = new Node[2];
        arr[0] = new Node("hello");
        arr[1] = new Node("world");
        for (Node node : arr) {
            System.out.println(node);
        }

        for (Iterator<Node> iterator = list.iterator(); iterator.hasNext();) {
            Node next = iterator.next();
            if (next.getName().equals("ty")) {
                next.setName("ty12");
            }
            System.out.println(next);
        }
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE).length());
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE % 3);
        System.out.println(Integer.MIN_VALUE % 2);
        System.out.println(-3 % 2);
        System.out.println((int) 'a');
        System.out.println((int) 'b');
        System.out.println('a' % 'b');
        System.out.println('b' % 'a');
        System.out.println('a' & 'b');
        System.out.println(Integer.toBinaryString('a'));
        System.out.println(Integer.toBinaryString('b'));
        char a = 'd';
        char b = 'f';
        System.out.println((int) a);
        System.out.println((int) b);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(a % b);
    }

    @Data
    static class Node{
        private String name;

        public Node(String name) {
            this.name = name;
        }
    }
}
