package com.tuyu.jstack;

import java.util.concurrent.*;

/**
 * 测试jstack工具
 * <pre>
 *     1. top查看cpu占用最高的进程，PID=1176
 *     2. linux 机器上 可以使用top -Hp 1176查看该进程中CPU占用最高的线程得到线程id，转为16进制
 *     3. 使用jstack PID可以生成thread dump信息，包含了所有存活线程，进行分析
 *
 * </pre>
 * @author tuyu
 * @date 9/20/18
 * Talk is cheap, show me the code.
 */
public class JstackTest {

    public static void main(String[] args) {
        int threadNum = 2;
        // 涉及到多个线程执行，考虑用线程池，为了清除线程池的构造，决定使用ThreadPoolExecutor
        // 线程数量固定为2， 存活时间为0ms，即不销毁ide的线程，使用LinkedBlockingQueue，
        // 使用Executors默认的线程工厂，使用ThreadPoolExecutor中默认的丢弃任务的拒绝执行处理器
        ExecutorService executorService = new ThreadPoolExecutor(threadNum
                , threadNum
                , 0
                , TimeUnit.MILLISECONDS
                , new LinkedBlockingDeque<Runnable>()
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.DiscardPolicy());

        Object lock = new Object();

        for(int i = 0; i < threadNum; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    synchronized (lock){
                        // 线程长时间持有锁，并且不释放，其他线程只能等待，模拟cpu使用率居高不小
                        while (true) {
                            i++;
                        }
                    }
                }
            });
        }
    }
}
