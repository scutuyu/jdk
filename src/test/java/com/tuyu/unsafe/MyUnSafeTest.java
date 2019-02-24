package com.tuyu.unsafe;

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
 * tuyu于5/22/18祈祷...
 * 测试获取Unsafe实例方法
 * @author tuyu
 * @date 5/22/18
 * Stay Hungry, Stay Foolish.
 */
public class MyUnSafeTest {
    /**
     * 获取Unsafe实例
     * @throws Exception
     */
    @Test
    public void getUnsafe() throws Exception {
        System.out.println(MyUnSafe.getUnsafe());
    }

    /**
     * 测试break关键字，当有多重循环时，break是跳出内层循环，还是跳出所有循环
     * 结果显示，只能跳出当前循环，不能跳出外层循环
     */
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println("outer");
            while (true) {
                System.out.println("middle");
                while (true) {
                    System.out.println("inner");
                    break;
                }
                Thread.currentThread().sleep(1000L);
            }
        }
    }

}