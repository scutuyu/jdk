package com.tuyu.thread;

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
public class WaitThread implements Runnable {
    private Object object;

    public WaitThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        // 运行10秒钟
        long now = System.currentTimeMillis();
        while (System.currentTimeMillis() - now < 2000L){
            // do nothing
        }

        // 调用wait()方法
        synchronized (object){
            try {
                object.wait();
                // 被唤醒后运行2秒钟结束
                System.out.println("get lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        now = System.currentTimeMillis();
        while (System.currentTimeMillis() - now < 2000L){
            // do nothing
        }
    }
}
