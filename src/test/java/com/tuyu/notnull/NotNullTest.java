package com.tuyu.notnull;

import org.junit.Test;

import java.math.BigDecimal;

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
 * tuyu于7/5/18祈祷...
 * 在使用构造函数或调用函数时，如果需要传递的参数不能为null，让IDE提示不能传null
 * @author tuyu
 * @date 7/5/18
 * Stay Hungry, Stay Foolish.
 */
public class NotNullTest {

    @Test
    public void testNotNull() {
        Phone phone = new Phone(null, 1);

    }

    @Test
    public void testNull() {
        BigDecimal price = null;
        // 下面的方式不会抛异常
        System.out.println(String.valueOf(price));
        // 下面的方式将会跑NPE异常
        System.out.println(price.toString());
    }
}
