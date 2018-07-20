package com.tuyu.io;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

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
 * 测试管道的InputStream和OutputStream
 * @author tuyu
 * @date 7/11/18
 * Stay Hungry, Stay Foolish.
 */
public class PipedLineTest {

    public static void main(String[] args) throws IOException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        // 下面两行代码保留一行即可，不然会报错IOException Already connected
        inputStream.connect(outputStream);
//        outputStream.connect(inputStream);

        String data = "a";
//        System.out.println("单线程中，PipedOutputStream先调write方法往管道中写数据，PipedInputStream再调read方法从管道中读数据：");
//        System.out.println("PipedOutputStream开始写入数据: " + data);
//        outputStream.write(data.getBytes());
//        int read = inputStream.read();
//        System.out.println("PipedInputStream收到数据: " + read);

        System.out.println("单线程中，PipedInputStream先调read方法从管道中读数据，PipedOutputStream先调write方法往管道中写数据：\n已发生死锁...");
        int read2 = inputStream.read();
        System.out.println("PipedInputStream收到数据: " + read2);
        System.out.println("PipedOutputStream开始写入数据: " + data);
        outputStream.write(data.getBytes());
        inputStream.close();
        outputStream.close();
    }

    @Test
    public void testCharTransfor() {
        for (int i = -100; i < 100; i++) {
            char a = (char)(i & 0xFF);
            System.out.println("i = "+ i + " char = " + a + " byte = " + (byte)a);
        }
    }

    @Test
    public void test() {
        System.out.println(-26 & 0xff);
        System.out.println(getInt());
    }

    public static int getInt(){
        Integer x = 1;
        try {
            x = 2;
            throw new RuntimeException();
//            return x;
        } catch (Exception e) {
            x = 3;
            return x;
        }finally {
            x = 4;
        }
    }
}
