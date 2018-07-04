package com.tuyu.spi;

import java.util.ServiceLoader;

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
 * tuyu于6/29/18祈祷...
 *
 * @author tuyu
 * @date 6/29/18
 * Stay Hungry, Stay Foolish.
 */
public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<HelloInterface> loader = ServiceLoader.load(HelloInterface.class);

        for (HelloInterface helloInterface : loader) {
            helloInterface.sayHello();
        }

        // 下面的代码不能运行，内部类可以访问外部类的成员变量，而静态方法不能直接访问类的成员变量，产生矛盾，所以静态方法中不能实例化静态类
//        Inner inner = new Inner();
    }

    public void hello() {
        // 下面的代码可以运行，内部类可以访问外部类的成员变量
        Inner tuyu = new Inner(1, "tuyu");
        System.out.println(toString());
    }

    // 私有内部类
    private class Inner {
        private int age;
        private String name;
        private Inner(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
