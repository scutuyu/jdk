package com.tuyu.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * ////////////////////////////////////////////////////////////////////
 * //                          _ooOoo_                               //
 * //                         o8888888o                              //
 * //                         88" . "88                              //
 * //                         (| ^_^ |)                              //
 * //                         O\  =  /O                              //
 * //                      ____/`---'\____                           //
 * //                    .'  \\|     |//  `.                         //
 * //                   /  \\|||  :  |||//  \                        //
 * //                  /  _||||| -:- |||||-  \                       //
 * //                  |   | \\\  -  /// |   |                       //
 * //                  | \_|  ''\---/''  |   |                       //
 * //                  \  .-\__  `-`  ___/-. /                       //
 * //                ___`. .'  /--.--\  `. . ___                     //
 * //              ."" '<  `.___\_<|>_/___.'  >'"".                  //
 * //            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
 * //            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
 * //      ========`-.____`-.___\_____/___.-`____.-'========         //
 * //                           `=---='                              //
 * //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
 * //             佛祖保佑       永无BUG     永不修改                   //
 * ////////////////////////////////////////////////////////////////////
 * </pre>
 * tuyu于5/14/18祈祷...
 *<p>自己实现的阻塞队列</p>
 * 用链表实现BlockingQueue
 * @author tuyu
 * @date 5/14/18
 * Stay Hungry, Stay Foolish.
 */
public class MyBlockingQueue<E> implements BlockingQueue<E> {

    private Node<E> head;
    private Node<E> last;
    private AtomicInteger count = new AtomicInteger(0);
    private volatile int size;

    private ReentrantLock putLock = new ReentrantLock();
    private ReentrantLock takeLock = new ReentrantLock();
    private Condition notFull = putLock.newCondition();
    private Condition notEmpty = takeLock.newCondition();

    public MyBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public MyBlockingQueue(int size) {
        this.size = size;
        this.head = this.last = new Node<>(null);
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void put(E o) throws InterruptedException {
        if (o == null){
            throw new InterruptedException("parameter is null");
        }
        int c = -1;
        AtomicInteger count = this.count;
        final ReentrantLock putLock = this.putLock;
        final Condition notFull = this.notFull;

//        putLock.lock();
        putLock.lockInterruptibly();
        try {
            while (count.get() == size){
                notFull.await();
            }
            enqueue(o);
            c = count.incrementAndGet();
            if (c + 1 < size){
                notFull.signal(); // 为什么不调用signalAll(),估计是因为性能问题，如果队列还能添加1个或2个元素，调用signalAll()将唤醒所有生产者线程，当线程被唤醒后发现不能生产数据就会await，会极大的浪费性能
            }


        } finally {
            putLock.unlock();
        }
        if (count.get() == 0){
            signalNotEmpty();
        }
    }

    private void signalNotEmpty(){

        final ReentrantLock takeLock = this.takeLock;
        Condition notEmpty = this.notEmpty;
        takeLock.lock();
        try {
            if (this.count.get() > 0){
                notEmpty.signalAll();
            }
        } finally {
            takeLock.unlock();
        }
    }

    private boolean enqueue(E e){
        this.last = this.last.next = new Node<>(e);
        return true;
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public E take() throws InterruptedException {
        AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        final Condition notEmpty = this.notEmpty;
        E re = null;
        takeLock.lockInterruptibly();
        try {
            while (count.get() <= 0){
                notEmpty.await();
            }
            re = dequeue();
            count.decrementAndGet();
            if (count.get() > 0){
                notEmpty.signalAll();
            }
        } finally {
            takeLock.unlock();
        }
        if (count.get() < size){
            signalNotFull();
        }
        return re;
    }

    private void signalNotFull(){
        final ReentrantLock putLock = this.putLock;
        final Condition notFull = this.notFull;
        putLock.lock();
        try {
            if (this.count.get() < this.size){
                notFull.signalAll();
            }
        } finally {
            putLock.unlock();
        }
    }

    private E dequeue(){
        Node<E> h = this.head;
        Node<E> first = h.next;
        E re = first.item;
        this.head = first;
        h.next = h;
        first.item = null; // 出队，数据清空
        return re;
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return this.count.get();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }

    static class Node<E>{
        private E item;
        private Node<E> next;
        public Node(E e){
            this.item = e;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }


}
