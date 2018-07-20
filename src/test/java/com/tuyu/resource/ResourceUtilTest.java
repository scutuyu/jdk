package com.tuyu.resource;

import com.tuyu.url.UrlTest;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

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
 * 资源加载 测试类
 * @author tuyu
 * @date 6/1/18
 * Stay Hungry, Stay Foolish.
 */
public class ResourceUtilTest {


    /**
     * clazz.getClassLoader().getResourceAsStream
     * <pre>
     *     路径相对于classpath
     *     开头不要加 /
     * </pre>
     */
    @Test
    public void testLoadPath1() {
        Assert.assertNotNull(ResourceUtil.getResourceAsStream("log4j.properties"));
    }

    /**
     * 路径要相对于classpath，
     * clazz.getClassLoader().getResourceAsStream
     * <pre>
     *     路径相对于classpath
     *     开头不要加 /
     * </pre>
     */
    @Test
    public void testLoadPath2() {
        Assert.assertNotNull(ResourceUtil.getResourceAsStream("com/tuyu/resource/prop.properties"));
    }

    /**
     * clazz.getResourceAsStream
     * <pre>
     *     路径相对于classpath
     *     开头要加 /
     * </pre>
     */
    @Test
    public void testLoadPath3() {
        Assert.assertNotNull(ResourceUtil.getResourceFromPackagePath("/log4j.properties"));
    }

    /**
     * clazz.getResourceAsStream
     * <pre>
     *     路径相对于classpath
     *     开头要加 /
     * </pre>
     */
    @Test
    public void testLoadPath4() {
        Assert.assertNotNull(ResourceUtil.getResourceFromPackagePath("/com/tuyu/resource/prop.properties"));
    }

    /**
     * 测试 加载配置文件并保存到Properties对象中
     */
    @Test
    public void testProperties() {
//        Properties properties = ResourceUtil.getProperties("/jdbc.properties");
        Properties properties = ResourceUtil.getProperties("jdbc.properties");
        System.out.println(properties);
    }

    @Test
    public void testSysSeparator() {
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
    }

    /**
     * 测试 字符串可以与字符用+进行连接
     */
    @Test
    public void testStringPlusChar() {
        System.out.println("" + 'a');
        String name = "tuyu";
        System.out.println(name + 'b');
    }
}