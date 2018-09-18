package com.tuyu.collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tuyu
 * @date 9/17/18
 * Talk is cheap, show me the code.
 */
public class ArrayListTest {

    private static final Logger logger = LoggerFactory.getLogger(ArrayListTest.class);

    @Test
    public void testClone() {
        ArrayList<Node> list = new ArrayList<>(2);
        list.add(new Node("tuyu"));
        list.add(new Node("ty"));

        ArrayList<Node> list2 = (ArrayList<Node>) list.clone();
        logger.info("lit == list2 ? {}", list == list2);
        for (int i = 0; i < list.size(); i++) {
            logger.info("list.get({}) == list2.get({}) ? {}", i, i, list.get(i) == list2.get(i));
        }
    }

    @Test
    public void testEquals() {
        Node node1 = new Node("tuyu");
        Node node2 = new Node("ty");
        List<Node> arrList = new ArrayList<>(2);
        arrList.add(node1);
        arrList.add(node2);
        List<Node> linkList = new LinkedList<>();
        linkList.add(node1);
        linkList.add(node2);
        logger.info("arrList.equals(linkList) ? {}", arrList.equals(linkList));
        logger.info("linkList.equals(arrList) ? {}", linkList.equals(arrList));
    }

    static class Node{
        private String name;

        public Node(String name) {
            this.name = name;
        }
    }
}
