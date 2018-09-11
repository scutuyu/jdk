package com.tuyu.locksupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CLH自旋锁测试
 * @author tuyu
 * @date 9/11/18
 * Talk is cheap, show me the code.
 */
public class ClhSpinLockTest {

    private static final Logger logger = LoggerFactory.getLogger(ClhSpinLockTest.class);

    private static int counter = 0;

    /**
     * 10个线程共同去累加一个变量的值,
     * 每个线程加1000次，
     * 验证最终变量的值是否为10000
     * @param args
     */
    public static void main(String[] args) {
        // 实例化一个CLH锁
        ClhSpinLock lock = new ClhSpinLock();
        // 模拟多个线程同时执行，建议使用线程池
        int threadNum = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                // 当所有线程的任务都执行完了，打印counter的值
                logger.info("counter: {}", counter);
                // 关闭线程池，不然程序不会结束
                executorService.shutdown();
            }
        });
        for (int i = 0; i < threadNum; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    // 线程在执行累加任务前需要先获取自旋锁
                    lock.lock();
                    logger.info("get the lock, and start the task...");
                    for (int i = 0; i < 1000; i++)
                        counter++;
                    // 当线程执行完累加任务后，释放自旋锁
                    lock.unlock();
                    logger.info("task end");
                    //释放锁字后 ，在cyclicBarrier处等待其他线程执行完任务
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
