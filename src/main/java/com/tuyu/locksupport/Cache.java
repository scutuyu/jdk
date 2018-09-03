package com.tuyu.locksupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 高性能缓存，支持并发读取和单一写入
 * <pre>
 *     [2018-09-03 16:40:19.26] Thread [main] running Method [put()]
 [2018-09-03 16:40:24.35] Thread [myThread0] running Method [get()]
 [2018-09-03 16:40:24.36] Thread [myThread3] running Method [get()]
 [2018-09-03 16:40:24.36] Thread [myThread1] running Method [get()]
 [2018-09-03 16:40:24.36] Thread [myThread2] running Method [get()]
 [2018-09-03 16:40:24.36] Thread [myThread6] running Method [get()]
 [2018-09-03 16:40:24.36] Thread [myThread5] running Method [get()]
 [2018-09-03 16:40:24.36] Thread [myThread4] running Method [get()]
 [2018-09-03 16:40:24.36] Thread [myThread7] running Method [get()]
 [2018-09-03 16:40:24.37] Thread [myThread8] running Method [get()]
 [2018-09-03 16:40:24.37] Thread [myThread9] running Method [get()]
 [2018-09-03 16:40:34.37] Thread [myThread5] get Data [world] from cache
 [2018-09-03 16:40:34.38] Thread [myThread8] get Data [world] from cache
 [2018-09-03 16:40:34.38] Thread [myThread3] get Data [world] from cache
 [2018-09-03 16:40:34.37] Thread [myThread1] get Data [world] from cache
 [2018-09-03 16:40:34.37] Thread [myThread7] get Data [world] from cache
 [2018-09-03 16:40:34.37] Thread [myThread2] get Data [world] from cache
 [2018-09-03 16:40:34.38] Thread [myThread5] running Method [put()]
 [2018-09-03 16:40:34.37] Thread [myThread9] get Data [world] from cache
 [2018-09-03 16:40:34.37] Thread [myThread6] get Data [world] from cache
 [2018-09-03 16:40:34.37] Thread [myThread4] get Data [world] from cache
 [2018-09-03 16:40:34.37] Thread [myThread0] get Data [world] from cache
 [2018-09-03 16:40:39.40] Thread [myThread8] running Method [put()]
 [2018-09-03 16:40:44.43] Thread [myThread3] running Method [put()]
 [2018-09-03 16:40:49.47] Thread [myThread1] running Method [put()]
 [2018-09-03 16:40:54.48] Thread [myThread7] running Method [put()]
 [2018-09-03 16:40:59.52] Thread [myThread2] running Method [put()]
 [2018-09-03 16:41:04.56] Thread [myThread9] running Method [put()]
 [2018-09-03 16:41:09.61] Thread [myThread6] running Method [put()]
 [2018-09-03 16:41:14.67] Thread [myThread4] running Method [put()]
 [2018-09-03 16:41:19.71] Thread [myThread0] running Method [put()]
 * </pre>
 * <p>
 *     从日志可以看出，当有多个线程同时读取缓存时，没有被阻塞，可以同时读取，当有多个线程往缓存写数据时只能允许单个线程写
 * </p>
 * @author tuyu
 * @date 9/3/18
 * Talk is cheap, show me the code.
 */
public class Cache {

    private Map<String, Object> map = new HashMap<>(10);

    public Cache() {
    }

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private static SimpleDateFormat simpleDateFormat;

    static {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    }

    public Object get(String key) {
        Object o = null;
        readLock.lock();
        try {
            // 模拟多个读线程可以同时读，因此在读方法上睡眠10s
            System.out.println(String.format("[%s] Thread [%s] running Method [%s]", simpleDateFormat.format(new Date()), Thread.currentThread().getName(), "get()"));
            Thread.sleep(10000L);
            o = map.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return o;
    }

    public Object put(String key, Object value) {
        Object o = null;
        writeLock.lock();
        try {
            // 只有一个线程可以写
            System.out.println(String.format("[%s] Thread [%s] running Method [%s]", simpleDateFormat.format(new Date()), Thread.currentThread().getName(), "put()"));
            Thread.sleep(5000L);
            o = map.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
        return o;
    }


    public static void main(String[] args) {
        int tNum = 10;
        Cache cache = new Cache();
        // 先往缓存中写入一条数据
        final String key = "hello";
        cache.put(key, "world");
        // tNum个线程同时访问cache,读完cache后，同时往cache中写数据
        for (int i = 0; i < tNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 读数据
                    Object o = cache.get(key);
                    System.out.println(String.format("[%s] Thread [%s] get Data [%s] from cache", simpleDateFormat.format(new Date()), Thread.currentThread().getName(), o));
                    // 写数据
                    cache.put(key, "new name" + Thread.currentThread().getName());
                }
            }, "myThread" + i).start();
        }
    }
}
