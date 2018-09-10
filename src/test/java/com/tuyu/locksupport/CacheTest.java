package com.tuyu.locksupport;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author tuyu
 * @date 9/5/18
 * Talk is cheap, show me the code.
 */
public class CacheTest {

    @Test
    public void testCache() throws InterruptedException {
        int tNum = 10;
        Cache cache = new Cache();
        // 先往缓存中写入一条数据
        final String key = "hello";
        cache.put(key, "world");
        CountDownLatch latch = new CountDownLatch(tNum);
        // tNum个线程同时访问cache，或者往cache中写数据
        for (int i = 0; i < tNum; i++) {
            final CountDownLatch countDownLatch = latch;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean read = Math.random() > 0.5;
                    if (read) {
                        // 读数据
                        Object o = cache.get(key);
                        System.out.println(String.format("[%s] Thread [%s] get Data [%s] from cache", Cache.simpleDateFormat.format(new Date()), Thread.currentThread().getName(), o));

                    } else {
                        // 写数据
                        cache.put(key, "new name" + Thread.currentThread().getName());
                    }
                    latch.countDown();
                }
            }, "myThread" + i).start();
        }
        latch.await();
    }
}
