package com.tuyu.constants;

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
 * tuyu于7/6/18祈祷...
 * Java移位运算符定义常量
 * <p>
 *     参考链接：https://blog.csdn.net/x844010689/article/details/8907337
 * </p>
 * <pre>
 *     多个常量的复合 int value = HAVE_VERIFY | HAVE_ACCEPTED
 *     验证是否包含某个常量 boolean b = value & HAVE_ACCEPTED > 0;
 *     将某个已包含的常量去掉 value = value & ~HAVE_ACCEPTED;
 * </pre>
 * @author tuyu
 * @date 7/6/18
 * Stay Hungry, Stay Foolish.
 */
public class Constants {

    private Constants(){}

    /** 已核实 */
    public static final int HAVE_VERIFY = 1 << 1;
    /** 已受理 */
    public static final int HAVE_ACCEPTED = 1 << 2;
    /** 已立案 */
    public static final int HAVE_REGISTERED = 1 << 3;
    /** 已派遣 */
    public static final int HAVE_DISPATCHED = 1 << 4;
    /** 已处置 */
    public static final int HAVE_DISPOSED = 1 << 5;
    /** 已核查 */
    public static final int HAVE_CHECKED = 1 << 6;
    /** 已结案 */
    public static final int HAVE_CLOSED = 1 << 7;

}
