package com.tuyu.oom;

import java.util.ArrayList;
import java.util.List;

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
 * tuyu于6/30/18祈祷...
 * 让java堆发生OutOfMemoryError异常
 * <p>
 *     vm args: -Xms10M -Xmx10M -XX:+HeapDumpOnOutOfMemoryError
 * </p>
 * @author tuyu
 * @date 6/30/18
 * Stay Hungry, Stay Foolish.
 */
public class JavaHeapOOM {

    private static int i = 0;
    public static void main(String[] args){
        try{
            hello();
        }catch(Throwable e){
            System.out.println("i = " + i);
            e.printStackTrace();
        }
    }

    public static void hello(){
        i++;
        hello();
    }
}


