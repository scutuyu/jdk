package com.tuyu.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author tuyu
 * @date 9/12/18
 * Talk is cheap, show me the code.
 */
public class ListIteratorTest {


    public static void main(String[] args) {
        List<Node> list = new ArrayList<>(10);
        list.add(new Node("hello"));
        list.add(new Node("world"));
        list.add(new Node("hi"));
        list.add(new Node("tuyu"));
        list.add(new Node("ty"));
        Iterator<Node> iterator = list.iterator();
        while (iterator.hasNext()) {
            Node next = iterator.next();
            System.out.println(next);
            if (next.getName().equals("hi")) {
                // 将hi改为hhii
                int i = list.indexOf(next);
                list.set(i - 1, new Node("hhii"));
                // 通过list直接删除元素,抛ConcurrentModificationException异常
//                list.remove(next);
                // 通过list新增元素,抛ConcurrentModificationException异常
//                list.add("newString");
                // 通过iterator删除当前元素
//                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private static class Node {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
