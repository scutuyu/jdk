package com.tuyu.lombok;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Slf4j
public class LombokTest {

    private static final Logger logger = LoggerFactory.getLogger(LombokTest.class);

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

        log.info("{}", cup);
        logger.info("{}", cup);

        /**
         * <pre>
         *     =%-d{yyyy-MM-dd HH:mm:ss SSS} ->[%t]--[%-5p]--[%c{1}]--%m%n
         *     2018-09-26 15:56:18 078 ->[main]--[INFO ]--[LombokTest]--Cup(name=tuyu, age=12, color=blank, createTime=Wed Sep 26 15:56:18 CST 2018)
         *     =%d{yyyy-MM-dd HH:mm:ss SSS} ->[%t]--[%-5p]--[%c{1}]--%m%n
         *     2018-09-26 15:57:11 867 ->[main]--[INFO ]--[LombokTest]--Cup(name=tuyu, age=12, color=blank, createTime=Wed Sep 26 15:57:11 CST 2018)
         *     =%d{yyyy-MM-dd HH:mm:ss SSS} ->[%t]--[%-5p]--[%c{10}]--%m%n
         *     2018-09-26 15:59:36 658 ->[main]--[INFO ]--[com.tuyu.lombok.LombokTest]--Cup(name=tuyu, age=12, color=blank, createTime=Wed Sep 26 15:59:36 CST 2018)
         *     =%d{yyyy-MM-dd HH:mm:ss SSS} ->[%t]--[%-5p]--[%c{10}]--%m
         *     2018-09-26 16:00:10 100 ->[main]--[INFO ]--[com.tuyu.lombok.LombokTest]--Cup(name=tuyu, age=12, color=blank, createTime=Wed Sep 26 16:00:10 CST 2018)Disconnected from the target VM, address: '127.0.0.1:52839', transport: 'socket'
         * </pre>
         *
         */
    }
}
