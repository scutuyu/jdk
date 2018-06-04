package com.tuyu.collection.linklist;

import org.junit.Test;

import static org.junit.Assert.*;

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
 * 不带头结点的单链表测试类
 * @author tuyu
 * @date 6/1/18
 * Stay Hungry, Stay Foolish.
 */
public class NoneHeaderLinkedListTest {

    MyList<String> list = new NoneHeaderLinkedList<>();

    /**
     * add(E e)
     */
    @Test
    public void add() {
        list.add("string");
        list.display();
        list.add("hello");
        list.display();
        list.add("world");
        list.display();
    }

    /**
     * add(int index, E e)
     */
    @Test
    public void add1() {
        list.add(0, "hello");
        list.add(0, "world");
        list.add(2, "string");
        list.add(1, "ds");
        list.display();
    }

    /**
     * remove(int index)
     */
    @Test
    public void remove() {
//        list.remove(0);
        list.add("hello");
        list.remove(0);
        list.add("world");
        list.add("string");
        list.add("ds");
        list.remove(2);
        list.add("ij");
        list.add("dsaf");
        list.add("jjjjj");
        list.remove(1);
        list.display();
    }

    /**
     * remove(Object o)
     */
    @Test
    public void remove1() {
        list.remove(null);
        list.add("hello");
        list.display();
        list.remove("hello");
        list.display();
        list.add("world");
        list.add("string");
        list.add("ds");
        list.display();
        list.remove("world");
        list.display();
        list.add("ij");
        list.add("dsaf");
        list.display();
        list.remove("dsaf");
        list.display();
        list.add("jjjjj");
        list.add("fdfd");
        list.add("ffasd");
        list.add("jjjfesejj");
        list.display();
        list.remove("jjjj");
        list.display();
        list.remove("jjjjj");
        list.display();
    }

}