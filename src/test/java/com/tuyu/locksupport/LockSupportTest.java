package com.tuyu.locksupport;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

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
 * <p>
 * tuyu于5/22/18祈祷...
 * 测试LockSupport.unpark()与park()
 * @author tuyu
 * @date 5/22/18
 * Stay Hungry, Stay Foolish.
 */
public class LockSupportTest {

    /**
     * 阻塞
     */
    @Test
    public void testLockSupport() {
        LockSupport.park();
        System.out.println("block.");
    }

    /**
     * 正常使用
     * <p>先unpark()在park()</p>
     * <p>先释放许可，在获取许可</p>
     */
    @Test
    public void testNormal() {
        Thread thread = Thread.currentThread();
        LockSupport.unpark(thread);//释放许可
        LockSupport.park();// 获取许可
        System.out.println("b");
    }

    /**
     * 不可重入
     */
    @Test
    public void testNotReentrant() {
        Thread thread = Thread.currentThread();

        LockSupport.unpark(thread);

        System.out.println("a");
        LockSupport.park();
        System.out.println("b");
        LockSupport.park();
        System.out.println("c");
    }

    /**
     * 能相应中断请求
     */
    @Test
    public void testInterapt() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            private int count = 0;
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 1000)
                {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 1 second.count=" + count);
                LockSupport.park();
                System.out.println("can accept interrupt signal, isInterrupted : " + Thread.currentThread().isInterrupted());
            }
        });

        thread.start();
        Thread.currentThread().sleep(50000L);
        thread.interrupt();
        System.out.println("main over");
    }

    @Test
    public void test() {
        System.out.println("net.xulingbo.classloader".startsWith("net.xulingbo"));

    }
}
