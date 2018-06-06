package com.tuyu.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
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
 * socket服务器
 * <p>使用telnet命令链接服务器</p>
 * 可以有多个客户端连接，但由于是单线程处理客户端请求，那么只能是前一个客户端断开连接之后再处理后一个客户端的请求
 * @author tuyu
 * @date 6/6/18
 * Stay Hungry, Stay Foolish.
 */
public class SingleUserSocketServer {
    private static int PORT = 8189;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            Scanner scanner = new Scanner(inputStream);
            printWriter.println("HELLO : " + socket + "\ninput exit to quit.");
            boolean done = false;
            while (!done && scanner.hasNextLine()) {
                System.out.println("SOCKET :" + socket);
                String s = scanner.nextLine();
                printWriter.println("Echo: " + s);
                if (s.trim().equals("exit")) {
                    done = true;
                }
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}
