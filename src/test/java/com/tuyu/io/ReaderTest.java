package com.tuyu.io;

import java.io.*;

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
 * tuyu于7/12/18祈祷...
 * 测试关于reader的类和api
 *
 * @author tuyu
 * @date 7/12/18
 * Stay Hungry, Stay Foolish.
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {


        // 测试具体装饰者InputStreamReader
//        testInputStreamReader();

        // 测试具体装饰者BufferedReader
//        testBufferedReader();

        // 测试具体装饰者PrintStream
        testPrintStream();
    }

    /**
     * 获取标准输入流的输入
     * @throws IOException
     */
    public static void testInputStreamReader() throws IOException {
        System.out.println("请输入字符，回车键结束：");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        int read = -1;
        StringBuilder stringBuilder = new StringBuilder();
        // 这里需要判断读到的字符是否是'\n',如果是，则结束循环
        while ((read = inputStreamReader.read()) != -1&& '\n' != (char)read) {
            stringBuilder.append((char) read);
        }
        System.out.println("\n读到字符：\n" + stringBuilder.toString());
        inputStreamReader.close();

        System.out.println("方法分隔符: ---------------------------" );
    }

    /**
     * 获取标准输入流的输入
     * @throws IOException
     */
    public static void testBufferedReader() throws IOException {
        System.out.println("请输入字符：");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bufferedReader.readLine();
            if ("exit".equals(s)) {
                bufferedReader.close();
                break;
            }
            System.out.println("\n读到字符：\n" + s);
        }
        System.out.println("方法分隔符: ---------------------------" );
    }

    public static void testPrintStream() throws IOException {
        String str = "src/test/resources/out.properties";
        File file = new File(str);

        // 如果文件的所在目录不存在，则创建
        if (!file.getParentFile().exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
            System.out.println("创建目录 " +  (mkdirs ? "成功" : "失败"));
        }
        // 如果文件不存在，则创建
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            System.out.println("创建文件 " + (newFile ? "成功" : "失败"));
        }
        System.out.println("后面的System.out.println方法将会把hello world字符串输出到 " + str + " 文件中, \n并会覆盖文件中已有的内容");
        String word = "hello world tuyu";
        System.out.println(word);
        System.setOut(new PrintStream(file));
        System.out.println(word);

    }

}
