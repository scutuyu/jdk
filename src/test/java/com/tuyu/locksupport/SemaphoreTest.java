package com.tuyu.locksupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 测试Semaphore
 * @author tuyu
 * @date 9/11/18
 * Talk is cheap, show me the code.
 */
public class SemaphoreTest {

    private static final Logger logger = LoggerFactory.getLogger(SemaphoreTest.class);

    /**
     * 信号量允许同时5个线程同时访问某个资源，
     * 访问资源前需要获取权限
     * 超过5个的其他线程要想访问资源，需要阻塞等待
     * 访问资源结束后需要释放
     * @param args
     */
    public static void main(String[] args) {
        int threadNum = 5;
        Semaphore semaphore = new Semaphore(threadNum);
        int maxThreadNum = 10;
        Random random = new Random();
        // 由于要模拟多个线程同时运行，建议使用线程池
        ExecutorService executorService = Executors.newFixedThreadPool(maxThreadNum);
        for (int i = maxThreadNum; i > 0; i--) {
            final Semaphore s = semaphore;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    logger.info("before visit");
                    try {
                        s.acquire();
                        logger.info("get a permission");
                        int time = random.nextInt(5000);
                        Thread.sleep(time);
                        logger.info("visiting the resource elapse time: {} ms", time);
                        logger.info("release the permission");
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    logger.info("end");
                }
            });
        }

        executorService.shutdown();
    }
}
