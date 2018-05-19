package com.tuyu.annotation;

import org.junit.Test;

import java.lang.reflect.Method;

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
 * tuyu于5/19/18祈祷...
 * 测试类
 * <p>测试自定义注解{@link com.tuyu.annotation.NeedTest}</p>
 * @author tuyu
 * @date 5/19/18
 * Stay Hungry, Stay Foolish.
 */
public class NeedTestTest {

    /**
     * 使用Java反射机制来访问自定义注解
     */
    @Test
    public void testCustomAnnotation() {
        Class clazz = MyService.class;
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length == 0){
            System.out.println("method " + clazz.getName() + " has no declared method");
        }else {
            for (Method method : methods){
                NeedTest annotation = method.getAnnotation(NeedTest.class); // 所有自定义的注解都隐式继承自java.lang.annotation.Annotation接口，但是不允许显示继承其他接口
                if (annotation == null){
                    System.out.println("method" + method.getName() + " has not annotated @NeedTest");
                }else {
                    boolean value = annotation.value();
                    System.out.println(method.getName() + " has annotated @NeedTest and value = " + value);
                }
            }
        }
    }
}
