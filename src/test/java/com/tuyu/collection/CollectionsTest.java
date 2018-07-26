package com.tuyu.collection;

import org.junit.Test;

import java.util.*;

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
 * 测试Collections类中常用方法
 *
 * @author tuyu
 * @date 7/5/18
 * Stay Hungry, Stay Foolish.
 */
public class CollectionsTest {

    @Test
    public void testSort() {
        List<String> list = new ArrayList<>();
        list.add("zoo");
        list.add("world");
        list.add("hello");
        System.out.println(list);
//        list.sort(null);
        Collections.sort(list);
        System.out.println(list);
    }


    /**
     *  对于ArrayList的toArray来说，是调用Arrays.arraycopy完成的，
     *  如果有传入了数组，如果数组能容纳所有的元素，就使用传入的元素来保存，
     *  否则就返回一个新的数组
     */
    @Test
    public void testToArray() {
        Collection collection = new ArrayList();
        collection.add("hello");
        collection.add("world");
        Object[] objects = collection.toArray();
        System.out.println("toArray()： " + Arrays.toString(objects));
//        Object[] arr = new Object[]{"obj1", "obj2", "obj3"};
        Object[] arr = new Object[]{"obj1"};
        Object[] objects1 = collection.toArray(arr);
        System.out.println("toArray(arr): " + Arrays.toString(objects1));
        System.out.println("arr: " + Arrays.toString(arr));
    }
}
