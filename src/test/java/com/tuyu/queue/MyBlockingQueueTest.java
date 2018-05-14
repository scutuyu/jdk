package com.tuyu.queue;

import org.junit.Test;

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
 * @author tuyu
 * @date 5/14/18
 * Stay Hungry, Stay Foolish.
 */
public class MyBlockingQueueTest {

    @Test
    public void testPutAndTake() throws InterruptedException{
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(5); // 链表实现的阻塞队列，初始容量是5，不指定这是Integer.MAX_VALUE
        Thread producer = new Thread(new Producer(queue), "1");
        Thread consumer = new Thread(new Consumer(queue), "1");
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
