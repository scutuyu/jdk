package com.tuyu.thread;

import java.util.Date;

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
public class MyThread implements Runnable {

    private Date date;

    public MyThread(Date date) {
        this.date = date;
    }

    @Override
    public void run() {
        // 运行10秒钟
        long now = System.currentTimeMillis();
        while (System.currentTimeMillis() - now < 2000L){
            // do nothing
        }
        // 睡眠10秒
        try {
            Thread.currentThread().sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
