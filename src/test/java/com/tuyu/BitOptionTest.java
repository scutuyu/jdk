package com.tuyu;

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
 * tuyu于6/7/18祈祷...
 * 位运算
 * @author tuyu
 * @date 6/7/18
 * Stay Hungry, Stay Foolish.
 */
public class BitOptionTest {

    /**
     * 左移，2的n次幂
     * <pre>
     *   2 的 0 次方是 1
         2 的 1 次方是 2
         2 的 2 次方是 4
         2 的 3 次方是 8
         2 的 4 次方是 16
         2 的 5 次方是 32
         2 的 6 次方是 64
         2 的 7 次方是 128
         2 的 8 次方是 256
         2 的 9 次方是 512
         2 的 10 次方是 1024
     * </pre>
     */
    @Test
    public void testLeft() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("2 的 " + i + " 次方是 " + (1 << i));
        }
    }

    /**
     * mysql中tinyint,smallint,mediumint,int,bigint的取值范围
     */
    @Test
    public void testValueRange() {
        System.out.println("有符号");
        System.out.println("tinyint 1 字节 -2^7~2^7-1 " + (-1 << 7) + "~" + ((1 << 7 ) - 1));
        System.out.println("smallint 2 字节 -2^15~2^15-1 " + (-1 << 15) + "~" + ((1 << 15) - 1));
        System.out.println("mediumint 3 字节 -2^23~2^23-1 " + (-1 << 23) + "~" + ((1 << 23) - 1));
        System.out.println("int 4 字节 -2^31~2^31-1 " + (-1 << 31) + "~" + ((1 << 31) - 1));
        System.out.println("bigint 8 字节 -2^63~2^63-1 " + (-1^63) + "~" + ((1 << 63) - 1));

        System.out.println("有符号");
        System.out.println("tinyint 1 字节 0~2^8-1 0" + "~" + ((1 << 8 ) - 1));
        System.out.println("smallint 2 字节 0~2^16-1 0" + "~" + ((1 << 16) - 1));
        System.out.println("mediumint 3 字节 0~2^24-1 0" + "~" + ((1 << 24) - 1));
        System.out.println("int 4 字节 0~2^32-1 0" + "~" + 0x7fffffff);
        System.out.println("bigint 8 字节 0~2^64-1 0" + "~" + 0x7fffffffffffffffL);
    }
}
