package com.tuyu.socket;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

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
 * tuyu于6/6/18祈祷...
 *
 * @author tuyu
 * @date 6/6/18
 * Stay Hungry, Stay Foolish.
 */
public class NowTimeTest {
    private String ip = "time-A.timefreq.bldrdoc.gov";
    private int port = 13;

    /**
     * 创建一个socket，并输出从socket获取到的信息
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        Socket socket = new Socket(ip, port);
        System.out.println("Socket : " + socket); // Socket : Socket[addr=time-A.timefreq.bldrdoc.gov/132.163.96.1,port=13,localport=63582]
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(s);
        }
        inputStream.close();
        socket.close();
    }

    /**
     * 通过主机名获取IP地址
     * InetAddress.getAllByName
     */
    @Test
    public void testGetHost() throws UnknownHostException {
        String host = "google.com";
        InetAddress[] addresses = InetAddress.getAllByName(host);
        /**
         * google.com/172.217.160.110
         * google.com/2404:6800:4012:0:0:0:0:200e
         */
        for (InetAddress a : addresses) {
            System.out.println(a);
        }
    }

    /**
     * 获取本机IP地址
     */
    @Test
    public void testGetLocalHost() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); // scutuyu.local/10.10.70.237
        System.out.println(InetAddress.getByName("localhost")); // localhost/127.0.0.1
    }
}
