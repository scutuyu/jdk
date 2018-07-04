package com.tuyu.lombok;

import lombok.Cup;
import org.junit.Test;

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
 * <p>
 * tuyu于7/4/18祈祷...
 * Lombok插件测试
 * @author tuyu
 * @date 7/4/18
 * Stay Hungry, Stay Foolish.
 */
public class LombokTest {


    /**
     * Cup实体类，定义了实例域，但是没有定义getter,setter方法，只是在类上使用了@Data注解，就可以自动生成getter，setter，toString等方法
     */
    @Test
    public void testLombok() {
        Cup cup = new Cup();
        cup.setName("tuyu");
        cup.setAge(12);
        cup.setColor("blank");
        cup.setCreateTime(new Date());

        System.out.println(cup);
    }
}
