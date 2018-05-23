package com.tuyu.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

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
 * 获取Unsafe实例
 * <p>参考链接：</p>
 * <p>https://www.cnblogs.com/chenpi/p/5389254.html#_label2</p>
 * @author tuyu
 * @date 5/22/18
 * Stay Hungry, Stay Foolish.
 */
public class MyUnSafe {

    /**
     * 利用Java的反射机制获取Unsafe类中的静态属性theUnsafe
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static final Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Class clazz = Unsafe.class;
        Field theUnsafe = clazz.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Object o = theUnsafe.get(null); // 由于是静态属性，传入null
        return (Unsafe) o;
    }
}
