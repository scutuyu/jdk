package com.tuyu.resource;

import com.tuyu.url.UrlTest;
import org.junit.Test;

import java.io.*;
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
 *
 * @author tuyu
 * @date 6/1/18
 * Stay Hungry, Stay Foolish.
 */
public class ResourceUtilTest {


    /**
     * 加载资源文件，并打印每一行
     */
    @Test
    public void testGet() throws IOException {
        InputStream inputStream = ResourceUtil.getResourceAsStream(ResourceUtilTest.class, "log4j.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = null;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }

    /**
     *
     */
    @Test
    public void testPacket() {
        InputStream resourceFromPackagePath = ResourceUtilTest.class.getResourceAsStream("prop.properties");
        Scanner scanner = new Scanner(resourceFromPackagePath);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        new ResourceUtilTest().print();
    }

    public void print(){
        InputStream resourceFromPackagePath = this.getClass().getResourceAsStream("prop.properties");
        Scanner scanner = new Scanner(resourceFromPackagePath);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(s);
        }
    }
}