package com.tuyu.array;

import org.junit.Test;

import java.util.Arrays;

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
 * tuyu于7/11/18祈祷...
 * 数组常用方法测试
 *
 * @author tuyu
 * @date 7/11/18
 * Stay Hungry, Stay Foolish.
 */
public class ArrayTest {

    /**
     * System.arraycopy是Native方法
     * <p>方法签名是: 源数组，源数组开始索引，目标数组，目标数组开始索引，要复制的元素个数</p>
     */
    @Test
    public void testSystemCopy() {
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 4;
        int[] arr2 = new int[4];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        System.out.println("将arr复制到arr2，从0出开始");
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("将arr复制到arr2，从2出开始");
        System.arraycopy(arr, 0, arr2, 2, arr.length);
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }

    /**
     * Arrays.copyOf静态方法
     * <p>默认从索引为0的位置开始复制，长度如果大于源数组的长度，超出的部分将会填充默认值</p>
     */
    @Test
    public void testArraysCopyOf() {
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 4;
        int[] arr2 = Arrays.copyOf(arr, 10);
        System.out.println("将arr复制到arr2");
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }

    public static void printArr(int[] arr){
        if (arr == null) {
            System.out.println("null");
            return;
        }
        int iMax = arr.length - 1;
        if (iMax == -1) {
            System.out.println("[]");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; ; i++) {
            stringBuilder.append(arr[i]);
            if (i == iMax) {
                System.out.println(stringBuilder.append("]").toString());
                return;
            }
            stringBuilder.append(", ");
        }
    }

    @Test
    public void testPringtArr() {
        printArr(null);
        printArr(new int[0]);
        printArr(new int[]{1, 3, 4, 5, 6});
    }

    /**
     * Arrays.copyOfRange静态方法
     * <p>开始索引不能超出源数组的边界，第二个参数可以大于源数组的边界</p>
     */
    @Test
    public void testCopyOfRange() {
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 4;
        int[] arr2 = Arrays.copyOfRange(arr, 0, 10);
        System.out.println("将arr复制到arr2");
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }

}
