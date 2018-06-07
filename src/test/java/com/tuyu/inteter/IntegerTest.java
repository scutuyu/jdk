package com.tuyu.inteter;

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
 * int测试类
 * @author tuyu
 * @date 6/7/18
 * Stay Hungry, Stay Foolish.
 */
public class IntegerTest {

    /**
     * 将int变量转为二进制字符串,高位0不显示
     */
    @Test
    public void testGetBinary() {
        String s = Integer.toBinaryString(102);
        System.out.println(s);
        System.out.println(Integer.toBinaryString(-102));
    }

    /**
     * 将int变量转为二进制字符串，显示高位0
     * <p>如果是有符号右移 >></p>
     * <pre>
     *     则结果是：
     *     -1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-2-3-6
     * </pre>
     * 如果是无符号右移 >>>
     * <pre>
     *     则结果是
     *     11111111111111111111111111111010
     * </pre>
     */
    @Test
    public void testGetBinary2() {
        int num = 102;
        System.out.println(Integer.toBinaryString(num));
        for (int i = 0; i < 32; i++) {
            int k = (num & (0x80000000) >>> i) >>> (31 -i);
            System.out.print(k);
        }
        System.out.println();
    }

    /**
     * float显示二进制字符串
     * <p>如果是正数，则最高位的0不显示</p>
     */
    @Test
    public void testFloatToBinary() {
        float f1 = 8.5f;
        int i = Float.floatToIntBits(f1);
        String s = Integer.toBinaryString(i);
        System.out.println(s);
    }
}
