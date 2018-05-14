package com.tuyu.queue;

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
 * 测试
 * <p>生产者向阻塞队列里添加数据，消费者在阻塞队列里消费数据</p>
 * @author tuyu
 * @date 5/14/18
 * Stay Hungry, Stay Foolish.
 */
public class Main {

    private static final MyBlockingQueue<String> queue = new MyBlockingQueue<>(5); // 链表实现的阻塞队列，初始容量是5，不指定这是Integer.MAX_VALUE

    public static void main(String[] args) {

        new Thread(new Producer(queue), "1").start();
        new Thread(new Consumer(queue), "1").start();
    }
}
