package com.tuyu.thread;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

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
 * tuyu于5/22/18祈祷...
 *
 * @author tuyu
 * @date 5/22/18
 * Stay Hungry, Stay Foolish.
 */
public class ThreadTest {

    private volatile Date date = new Date(); // 临界资源
    /**
     * 线程正常执行时状态的转移
     * <pre>
     *     NEW          ->   RUNNABLE     ->   TERMINATED
     *     new Thread()      start()           run()方法运行完
     * </pre>
     */
    @Test
    public void testNormal() throws InterruptedException{
        Thread thread = new Thread(new NormalThread());
        Thread.State state1 = thread.getState();
        System.out.println(state1);
        thread.start();
        Thread.State state2 = thread.getState();
        System.out.println(state2);
        Thread.State state3 = thread.getState();
        System.out.println(state3);
        thread.join();
        Thread.State state4 = thread.getState();
        System.out.println(state4);
    }

    /**
     * 线程sleep()之后的状态转移
     * <pre>
     *      NEW           ->     RUNNABLE      ->      TIMED_WAITING         ->    TERMINATED
     *      new Thread()         start()               sleep()                     执行完run()方法
     * </pre>
     */
    @Test
    public void testSleep() throws InterruptedException{
        Thread thread = new Thread(new SleepThread());
        Thread.State state1 = thread.getState();
        System.out.println(state1);
        thread.start();
        Thread.State state2 = thread.getState();
        System.out.println(state2);
        Thread.currentThread().sleep(2000L);
        Thread.State state3 = thread.getState();
        System.out.println(state3);
        thread.join();
        Thread.State state4 = thread.getState();
        System.out.println(state4);
    }

    /**
     * 线程因为获取锁资源失败进入BLOCKED状态
     * <pre>
     *     NEW              ->      RUNNABLE             ->       BLOCKED           ->      RUNNABLE               ->      TERMINATED
     *     new Thead()              start()                       获取锁失败                  获取锁成功                      运行完run()方法
     * </pre>
     * @throws InterruptedException
     */
    @Test
    public void testLock() throws InterruptedException {
        Thread thread = new Thread(new SynchronizedThread(date));
        Thread.State state1 = thread.getState();
        System.out.println(state1);
        thread.start();
        Thread.State state2 = thread.getState();
        System.out.println(state2);
        // 先获取myThread对象的锁，占用6秒钟后释放
        synchronized (date){
            long now = System.currentTimeMillis();
            while (System.currentTimeMillis() - now < 6000L){
                // do nothing
            }
        }
        Thread.State state3 = thread.getState();
        System.out.println(state3);

        Thread.currentThread().sleep(200L);
        Thread.State state4 = thread.getState();
        System.out.println(state4);
        thread.join();
        Thread.State state5 = thread.getState();
        System.out.println(state5);
    }

    /**
     * 调用wait()，notifyAll()方法之后状态转移
     * <pre>
     *     NEW           ->       RUNNABLE         ->        WAITING            ->    RUNNABLE         ->    TERMINATED
     *     new Thread()           start()                    wait()                   notifyAll()             run方法执行完
     * </pre>
     */
    @Test
    public void testWait() throws InterruptedException {
        Thread thread = new Thread(new WaitThread(date));
        // 线程新建后查看线程状态
        Thread.State state1 = thread.getState();
        System.out.println(state1);
        thread.start();
        // 线程开始运行后查看线程状态
        Thread.State state2 = thread.getState();
        System.out.println(state2);
        // 3秒之后唤醒线程
        Thread.currentThread().sleep(3000L);
        Thread.State state3 = thread.getState();
        System.out.println(state3);
        synchronized (date){
            date.notifyAll();
            System.out.println("release lock");
        }

        // 线程被唤醒后200毫秒再查看线程状态
        Thread.currentThread().sleep(200L);
        Thread.State state4 = thread.getState();
        System.out.println(state4);
        thread.join();
        // 线程运行结束后查看线程状态
        Thread.State state5 = thread.getState();
        System.out.println(state5);
    }

    /**
     * 调用join()方法之后
     * <pre>
     *     NEW             ->    RUNNABLE            ->        WAITING           ->         TERMINATED
     *     new Thread()          start()                       join()                       run()方法执行完
     * </pre>
     */
    @Test
    public void testJoin() throws InterruptedException {
        Thread thread = new Thread(new JoinThread(Thread.currentThread()));
        // 线程新建后查看线程状态
        Thread.State state1 = thread.getState();
        System.out.println(state1);
        thread.start();
        // 线程开始运行后查看线程状态
        Thread.State state2 = thread.getState();
        System.out.println(state2);
        thread.join();
        // 线程运行结束后查看线程状态
        Thread.State state3 = thread.getState();
        System.out.println(state3);
    }
}