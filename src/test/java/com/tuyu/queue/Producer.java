package com.tuyu.queue;

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
 *
 * 生产者
 * @author tuyu
 * @date 5/14/18
 * Stay Hungry, Stay Foolish.
 */
public class Producer implements Runnable{

    private MyBlockingQueue<String> queue;
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    public Producer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        CountDownLatch latch = new CountDownLatch(20);// 生产者生产20条数据之后退出
        try {
            String name = Thread.currentThread().getName();
            int i = 0;
           while (latch.getCount() > 0){
               String product = "P" + name + "-" + (++i);
               logger.info("---> producer\n {} product : {} + current queus size " + queue.size(),  name, product);
               queue.put(product);
               latch.countDown();
           }
           logger.info("---> producer\n{} : queue has {} elements", name, queue.size());
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
