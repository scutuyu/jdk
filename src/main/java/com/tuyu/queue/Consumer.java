package com.tuyu.queue;

import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

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
 * 消费者
 * @author tuyu
 * @date 5/14/18
 * Stay Hungry, Stay Foolish.
 */
public class Consumer implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    private MyBlockingQueue<String> queue;

    public Consumer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(6000L);
            String name = Thread.currentThread().getName();
            int num = 20; // 消费者线程消费num条数据后将会退出，如果队列中没有num条数据，消费者线程将会阻塞
            CountDownLatch latch = new CountDownLatch(num);
            while (latch.getCount() > 0){
                String re = queue.take();
                logger.info("--->Consumer\n{} consume : {}, current queue size : " + queue.size(), name, re);
                latch.countDown();
                Thread.currentThread().sleep(100L); // 消费者线程没消费一条数据就睡眠100毫秒
            }
            logger.info("---> consumer\n{} : queue has {} elements", name, queue.size());
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
