package com.tuyu.collection;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

/**
 * queue测试
 *
 * @author tuyu
 * @date 7/26/18
 * Talk is cheap, show me the code.
 */
public class QueueTest {

    /**
     * 使用ArrayBlockingQueue来验证offer方法和add方法在queue满后不同的表现
     * <pre>
     *     offer会返回false
     *     add会抛异常
     * </pre>
     */
    @Test
    public void testQueue() {
        Queue queue = new ArrayBlockingQueue(1);
        System.out.println("first offer: " + queue.offer("hello"));
        System.out.println("second offer: " + queue.offer("hello"));
        System.out.println("queue满后，offer方法返回false： " + Arrays.toString(queue.toArray()));
        try {
            System.out.println("second offer: " + queue.add("hello"));
        } catch (IllegalStateException e) {
            System.out.println("queue满后，add方法抛出异常\n");
            e.printStackTrace();
        }
    }

    /**
     * 使用ArrayBlockingQueue来验证remove方法和poll方法在queue满后不同的表现
     * <pre>
     *     poll会返回null
     *     remove会抛异常
     * </pre>
     */
    @Test
    public void testQueueRemove() {
        Queue queue = new ArrayBlockingQueue(1);
        Object poll = queue.poll();
        System.out.println("queue size 0, poll: " + poll);

        try {
            Object remove = queue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("queue size 0, remove: throws NoSuchElementException");
            e.printStackTrace();
        }
    }

    /**
     * 使用ArrayBlockingQueue来验证element方法和peek方法在queue满后不同的表现
     * <pre>
     *     peek会返回null
     *     element会抛异常
     * </pre>
     */
    @Test
    public void testQueueElement() {
        Queue queue = new ArrayBlockingQueue(1);
        Object peek = queue.peek();
        System.out.println("queue size 0, peek: " + peek);

        try {
            Object element = queue.element();
        } catch (NoSuchElementException e) {
            System.out.println("queue size 0, element: throws NoSuchElementException");
            e.printStackTrace();
        }
    }

    /**
     * ArrayBlockingQueue能添加null吗
     * <pre>
     *     在接口Queue中是这么说的：Queue不允许保存null，原因是部分方法返回特殊的值，比如poll,peek等在Queue为空时会返回null
     *     如果Queue中保存null，poll，peek方法就不能明确表明Queue是否为空，但是有个例外，LinkedList，它允许保存null
     * </pre>
     */
    @Test
    public void testNull() {
        Queue queue = new LinkedList();
        boolean offer = queue.offer(null);
        System.out.println("LinkedList 可以添加null: " + Arrays.toString(queue.toArray()));

        Queue queue1 = new ArrayBlockingQueue(2);
        try {
            boolean offer1 = queue.offer(null);
        } catch (NullPointerException e) {
            System.out.println("add, off, 方法都会检查插入的元素是否为null，如果为null，将抛异常");
            e.printStackTrace();
        }
    }
}
