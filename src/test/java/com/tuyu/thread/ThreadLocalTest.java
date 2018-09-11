package com.tuyu.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tuyu
 * @date 9/11/18
 * Talk is cheap, show me the code.
 */
public class ThreadLocalTest {

    private static final Logger logger = LoggerFactory.getLogger(ThreadLocalTest.class);

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocal<Node> pre = new ThreadLocal<>();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 先获取，默认是null
                Node node = pre.get();
                logger.info("{}", node);
                // 再设置
                Node n = new Node();
                n.locked = true;
                pre.set(n);
                // 设置后再获取
                logger.info("{}", pre.get());
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 先获取，默认是null
                Node node = pre.get();
                logger.info("{}", node);
                // 再设置
                Node n = new Node();
                n.locked = false;
                pre.set(n);
                // 设置后再获取
                logger.info("{}", pre.get());
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();

        // 主线程来获取
        logger.info("{}", pre.get());
        // 主线程设置后再获取
        Node n = new Node();
        n.locked = false;
        pre.set(n);
        logger.info("{}", pre.get());
    }


    static class Node {
        private volatile boolean locked;

        @Override
        public String toString() {
            return super.toString() + "-Node{" +
                    "locked=" + locked +
                    '}';
        }
    }
}
