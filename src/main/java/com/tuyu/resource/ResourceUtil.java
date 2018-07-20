package com.tuyu.resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
 * 获取资源的工具类
 * @author tuyu
 * @date 6/1/18
 * Stay Hungry, Stay Foolish.
 */
public class ResourceUtil {

    private ResourceUtil() {
        throw new AssertionError("ResourceUtil class can not be initialized");
    }

    /**
     * 从项目根目录加载资源文件
     * @param name 文件名
     * @return 返回inputStream输入流
     */
    public static final InputStream getResourceAsStream(String name){
        return getResourceAsStream(ResourceUtil.class, name);
    }

    /**
     * 从项目根目录加载资源文件
     * @param clazz 类对象
     * @param name 文件名
     * @return 返回inputStream输入流
     */
    public static final InputStream getResourceAsStream(Class clazz, String name){
        InputStream inputStream = clazz.getClassLoader().getResourceAsStream(name);
        return inputStream;
    }

    /**
     * 从包路径下加载资源文件
     * @param name 文件名
     * @return 返回inputStream输入流
     */
    public static final InputStream getResourceFromPackagePath(String name) {
        return getResourceFromPackagePath(ResourceUtil.class, name);
    }

    /**
     * 从包路径下加载资源文件
     * @param clazz 类对象
     * @param name 文件名
     * @return 返回inputStream输入流
     */
    public static final InputStream getResourceFromPackagePath(Class clazz, String name) {
        InputStream inputStream = clazz.getResourceAsStream(name);
        return inputStream;
    }

    /**
     * 加载配置文件
     * @param path
     * @return
     */
    public static final Properties getProperties(String path) {
        InputStream inputStream = null;
        if (path.startsWith(File.separator)) {
            inputStream = getResourceFromPackagePath(ResourceUtil.class, path);
        }else {
            inputStream = getResourceAsStream(ResourceUtil.class, path);
        }
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
