package com.tuyu.annotation;

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
 * service类
 * <p>使用自定义注解{@link com.tuyu.annotation.NeedTest}</p>
 * @author tuyu
 * @date 5/19/18
 * Stay Hungry, Stay Foolish.
 */
public class MyService {

    public void saySomething(){
        System.out.println("say something");
    }

    @NeedTest(true) // 成员名value()设置为true
    public void sayHello(String name){
        System.out.println("hello "+ name);
    }

    @NeedTest(false) // 成员名value()设置为false
    public void sayHi(String name){
        System.out.println("hi " + name);
    }
}
