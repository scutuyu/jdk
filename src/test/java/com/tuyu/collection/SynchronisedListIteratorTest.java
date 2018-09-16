package com.tuyu.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author tuyu
 * @date 9/12/18
 * Talk is cheap, show me the code.
 */
public class SynchronisedListIteratorTest {

    private static final Logger logger = LoggerFactory.getLogger(SynchronisedListIteratorTest.class);

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>(10);
        list.add(new Node("hello"));
        list.add(new Node("world"));
        list.add(new Node("hi"));
        list.add(new Node("tuyu"));
        list.add(new Node("ty"));
        final List<Node> fList = Collections.synchronizedList(list);

        logger.info("before task: {}", fList);
        Semaphore semaphore = new Semaphore(1);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                // 两个线程都执行完了就打印fList中的元素
                logger.info("after task: {}", fList);
            }
        });

        // 两个线程同时操作list，一个遍历，一个修改，线程不安全，需要实现同步访问
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 执行任务前先获取锁
                try {
                    semaphore.acquire();
                    // 遍历list
                    Iterator<Node> iterator = fList.iterator();
                    while (iterator.hasNext()) {
                        logger.info("{}", iterator.next());
                        // 每遍历一次，休息100ms
                        Thread.sleep(100L);
                    }
                    // 遍历完成后在cyclicBarrier处等待,并释放锁
                    semaphore.release();
                    int order = cyclicBarrier.await();
                    logger.info("order: {}", order);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 执行任务前先获取锁
                    semaphore.acquire();
                    // 新增元素
                    String name = "newString";
                    fList.add(new Node(name)); // 末尾加上newString
                    logger.info("add node: {}", name);
                    // 修改元素
                    name = "hellddddd";
                    logger.info("modified {} as {}", fList.get(0).name, name);
                    fList.set(0, new Node(name)); // hello改为hellddddd
                    // 访问元素
                    logger.info("the first element: {}", fList.get(0).name);
                    // 删除元素
                    logger.info("remove the third element: {}", fList.get(2).name);
                    fList.remove(2); // 删掉hi
                    // 任务执行完后在cyclicBarrier处等待,并释放锁
                    semaphore.release();
                    int order = cyclicBarrier.await(5L, TimeUnit.SECONDS);
                    logger.info("order: {}", order);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
        });
//        thread1.start();
        thread2.start();
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
