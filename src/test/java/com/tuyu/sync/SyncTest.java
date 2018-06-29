package com.tuyu.sync;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
 * tuyu于6/26/18祈祷...
 *
 * @author tuyu
 * @date 6/26/18
 * Stay Hungry, Stay Foolish.
 */
public class SyncTest {

    private static Map<String, Object> map = new ConcurrentHashMap<>(1);

    public static void main(String[] args) {
        map.put("hello", "world");
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (map) {
                    map.put("hello", "tuyu");
                    try {
                        Thread.sleep(Integer.MAX_VALUE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(map.get("hello"));
            }
        }).start();
    }

    /**
     * hashTable的value不允许为null
     * <p>如果key也为null，将抛出NPE</p>
     */
    @Test
    public void testNull() {
        Hashtable<String, Object> a = new Hashtable<>(1);
        a.put(null, "hello");
        System.out.println(a.get(null));

    }

    /**
     * concurrentHasMap的key和value都不允许为null
     */
    @Test
    public void testcc() {
        map.put(null, "hello");
        System.out.println(map.get(null));
    }

    /**
     * LinkedHashMap的key和value都允许为null
     */
    @Test
    public void testLi() {
        Map<String, Object> li = new LinkedHashMap<>(1);
        li.put(null, null);
        System.out.println(li.get(null));
    }

    /**
     * hashMap的key和value都允许为null
     */
    @Test
    public void testHas() {
        Map<String, Object> has = new HashMap<>(1);
        has.put(null, null);
        System.out.println(has.get(null));
    }

    /**
     * treeMap的key不允许null，value允许为null
     */
    @Test
    public void testtree() {
        Map<String, Object> trr = new TreeMap<>();
//        trr.put(null, "hello");
//        System.out.println(trr.get(null));
        trr.put("hello", null);
        System.out.println(trr.get("hello"));
    }
}
