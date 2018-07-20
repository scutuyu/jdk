package com.tuyu.constants;

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
 * <p>
 * tuyu于7/6/18祈祷...
 * 测试移位运算定义常量，以达到复合常量的目的
 * @author tuyu
 * @date 7/6/18
 * Stay Hungry, Stay Foolish.
 */
public class ConstantsTest {

    @Test
    public void testConstants() {
        int value = Constants.HAVE_VERIFY | Constants.HAVE_ACCEPTED;
        boolean verify = (value & Constants.HAVE_VERIFY) > 0;
        boolean accept = (value & Constants.HAVE_ACCEPTED) > 0;
        boolean close = (value & Constants.HAVE_CLOSED) > 0;
        System.out.println("value的是等于" + value + " 是否核实？ " + verify + " 是否受理？ " + accept + " 是否结案？ " + close);
        value = value & ~Constants.HAVE_ACCEPTED;
        System.out.println("value 取消已受理状态后的值为 " + value);
    }

    @Test
    public void test() {
        System.out.println(-1 << 29);
        System.out.println(0 << 29);
        System.out.println(1 << 29);
        System.out.println(2 << 29);
        System.out.println(3 << 29);
        System.out.println(4 << 29);
    }

    @Test
    public void testkk() {
    }
}
