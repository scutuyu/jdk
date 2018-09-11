package com.tuyu.locksupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试CyclicBarrier
 * @author tuyu
 * @date 9/11/18
 * Talk is cheap, show me the code.
 */
public class CyclicBarrierTest {

    private static final Logger logger = LoggerFactory.getLogger(CyclicBarrierTest.class);

    /**
     * <pre>
     *     5个线程在cyclicBarrier上等待，到齐之后同时执行；
     *     测试cyclicBarrier重复使用的特性
     * </pre>
     * @param args
     */
    public static void main(String[] args) {

        int threadNum = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum);

        // 多个线程同同时执行，考虑使用线程池
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);

        for (int i = 0; i < threadNum; i++) {
            final CyclicBarrier c = cyclicBarrier;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        logger.info("waiting for executing");
                        c.await();
                        logger.info("executed successfully");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    logger.info("end");
                }
            });
        }

        for (int i = 0; i < threadNum; i++) {
            final CyclicBarrier c = cyclicBarrier;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        logger.info("waiting for executing2");
                        c.await();
                        logger.info("executed successfully2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    logger.info("end2");
                }
            });
        }

        executorService.shutdown();
    }


}
