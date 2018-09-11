package com.tuyu.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * CHL Lock是自旋锁的一种,不支持重入
 * <p>
 *     https://segmentfault.com/a/1190000007094429
 * </p>
 * <pre>
 *
 * </pre>
 * @author tuyu
 * @date 9/11/18
 * Talk is cheap, show me the code.
 */
public class ClhSpinLock implements Lock {

    static class Node{
        private volatile boolean locked;
    }

    private AtomicReference<Node> tail = new AtomicReference<>(new Node());
    private ThreadLocal<Node> curr;
    private ThreadLocal<Node> pre;

    public ClhSpinLock() {
        // 初始化CLH自旋锁的时候，当前节点的初始值new Node()
        curr = new ThreadLocal<Node>(){
            @Override
            protected Node initialValue() {
                return new Node();
            }
        };
        // 初始化CLH自旋锁的时候，当前节点的前驱节点为null
        pre = new ThreadLocal<>();
    }

    @Override
    public void lock() {
        // 获取当前线程所对应的Node节点
        Node node = this.curr.get();
        // 将当前节点的状态设置为true
        node.locked = true;
        // 将tail指针指向当前线程对应的节点
        Node pre = this.tail.getAndSet(node);
        // 将返回的pre节点设置为当前线程需要检查的节点
        this.pre.set(pre);
        // 对当前线程的pre节点进行自旋,只要被锁住，lock方法就不返回
        while (pre.locked) {
            ;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        // 获取当前线程所对应的Node节点
        Node node = this.curr.get();
        // 将当前节点的状态设置为false
        node.locked = false;
        // 出队，当前节点的值设为当前节点的前驱节点
        this.curr.set(this.pre.get());
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}