package com.tuyu.collection.linklist;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

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
 * tuyu于6/1/18祈祷...
 *
 * @author tuyu
 * @date 6/1/18
 * Stay Hungry, Stay Foolish.
 */
public class LinkListTest {

    MyList<String> list;

    @Before
    public void before() {
        list = new WithHeaderLinkedList<>();
    }


    /**
     * 空列表删除null元素
     */
    @Test
    public void testRemoveNull() {
        try {
            list.remove(null);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 先添加null元素，在删除null元素
     */
    @Test
    public void testRemoveNull2() {
        list.add(null);
        System.out.println(list);
        list.remove(null);
        System.out.println(list);
    }

    /**
     * 添加元素
     */
    @Test
    public void testAdd() {
        list.add("hello");
        list.add("world");
        System.out.println(list);
        list.add("23");
        list.add(1, "22");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }

    /**
     * 删除元素
     */
    @Test
    public void testRemove() {
        System.out.println(list);
        list.add("hello");
        list.add("world");
        System.out.println(list);
        list.remove(null);
        list.remove("world");
        list.add("String");
        System.out.println(list);
        list.add("12");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
