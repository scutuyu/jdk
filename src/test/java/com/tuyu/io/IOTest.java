package com.tuyu.io;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.Selector;

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
 * tuyu于6/7/18祈祷...
 * I/O 测试
 * @author tuyu
 * @date 6/7/18
 * Stay Hungry, Stay Foolish.
 */
public class IOTest {

    /**
     * DataInput接口的readBoolean方法
     * <p>
     *     字节数组的数据如果是0，那么通过DataInputStream.readBoolean方法返回的是false，其他的数据是true
     * </p>
     */
    @Test
    public void testReadBoolean() throws IOException {
        byte[] arr = {21, 12, 0, 0, 122, 12, 122, 22};

        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(arr));
        while (dataInputStream.available() > 0) {
//            boolean b = dataInputStream.readBoolean();
//            System.out.println(b);

            long l = dataInputStream.readLong();
            System.out.println(l);
        }
    }

    /**
     * 在书写小数时，如果不写F或者D,则默认是double类型的
     * <p>所以在定义float变量时，如果不写f，则编译不通过，原因是双精度的double向下强制类型转换时可能会损失精度</p>
     */
    @Test
    public void testByte() {
        float float1 = 0.1F;
        float float2 = 0.9F;
        float float3 = float1 * float2;
        System.out.println("float float1 = 0.1F");
        System.out.println("float float2 = 0.9F");
        System.out.println("float3 = float1 * float2 = " + float3);
        System.out.println("float1 * float2 = " + float1 * float2);
        System.out.println("0.1F * 0.9F = " + 0.1F * 0.9F);
        System.out.println("0.1 * 0.9F = " + 0.1 * 0.9F);
        System.out.println("0.1F * 0.9 = " + 0.1F * 0.9);
        System.out.println("0.1 * 0.9 = " + 0.1 * 0.9);

        float1 *= 0.9F;
        System.out.println("float1 *= 0.9F = " + float1);
        float1 = 0.1F; // reset float1
        float1 *= 0.9;
        System.out.println("float1 *= 0.9 = " + float1);
    }

    /**
     * 打印65535个char字符
     */
    @Test
    public void testChar() {
        for (int i = 0; i < 65535; i++){
            System.out.println(i + " " + (char) i );
        }
    }

    @Test
    public void testINet() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("hostName: " + localHost.getHostName());
        System.out.println("address: " + localHost.getAddress());
        System.out.println("canonicalHostName: " + localHost.getCanonicalHostName());
        System.out.println("hostAdress: " + localHost.getHostAddress());
        System.out.println(localHost);
        InetAddress[] localhosts = InetAddress.getAllByName("localhost");
        System.out.println(localhosts);
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println(loopbackAddress);
    }

    @Test
    public void testSM() throws IOException {
        System.out.println(Selector.open());
        System.out.println(Selector.open());
        System.out.println(Selector.open());
        System.out.println(Selector.open());
    }

    /**
     * 测试具体被装饰者FileInputStream, FileOutputStream
     * <pre>
     *     read()方法是一个字节一个字节地读
     *     write()方法是一个字节一个字节地写
     *     使用完流之后，要调用close()方法关闭流
     * </pre>
     * 复制文件
     */
    @Test
    public void testFileInputStream() throws IOException {
        String from = "src/main/resources/log4j.properties";
        String to = "src/main/resources/to.properties";
        FileInputStream inputStream = new FileInputStream(from);
        FileOutputStream outputStream = new FileOutputStream(to);
        int available = inputStream.available();
        System.out.println("available: " + available + " bytes");
        System.out.println("begin: ");
        System.out.println("copy file: " + from + " to: " + to);
        int c = -1; // 读取一个字节
        while ((c = inputStream.read()) != -1){
            outputStream.write(c);
        }
        System.out.println("end: \ncopy success");
        outputStream.close();
        inputStream.close();
    }

    /**
     * 删除文件
     */
    @Test
    public void testDeleteFile() {
        String to = "src/main/resources/to.properties";
        File file = new File(to);
        System.out.println("begin: \ndelete file: " + to);
        boolean delete = file.delete();
        System.out.println("end: \ndeleted file: " + to + " success");
    }

    /**
     * 测试具体被装饰者ByteArrayInputStream和ByteArrayOutputStream
     * <pre>
     *     输出：
     *     '我'使用utf-8编码，需要要 3 bytes 来存储
     *      11100110 10001000 10010001
     *      230 	136 	145
     *      直接打印byte数组的值
     *      11111111111111111111111111100110 11111111111111111111111110001000 11111111111111111111111110010001
     *      -26 	-120   	 -111
     * </pre>
     * utf-8编码规则是一种变长编码，兼容ascii码，使用一个字节来表示ascii字符，中文可能两个字节，也可能三个字节
     * <pre>
     *     java中的一个char是2个字节。java采用unicode，2个字节来表示一个字符
     *     在 GB 2312 编码或 GBK 编码中，一个英文字母字符存储需要1个字节，一个汉字字符存储需要2个字节
     *     在UTF-16编码中，一个英文字母字符存储需要2个字节，一个汉字字符储存需要3到4个字节
     *     在UTF-32编码中，世界上任何字符的存储都需要4个字节
     *     https://blog.csdn.net/ns_code/article/details/14162087
     *
     *     unicode是字符集，规定了全世界所有字符的二进制编码，却没有规定该怎么存储
     *     utf-8是unicode的实现方式之一，使用变长编码的方式来存储字符，utf-8编码需要和unicode码进行转换
     * </pre>
     */
    @Test
    public void testCharacterSet() throws IOException {
        String name = "我HELlo";
        byte[] bytes = name.getBytes("utf-8");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        System.out.println("'" + name + "'使用utf-8编码，需要要 " + bytes.length + " bytes 来存储");
        int n = inputStream.available();
        int[] arr = new int[n];
        int c = -1;
        for (int i = 0; i < n; i++){
            c = inputStream.read();
            arr[i] = c;
            System.out.print(Integer.toBinaryString(c) + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        System.out.println("直接打印byte数组的值");
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(Integer.toBinaryString(bytes[i]) + " ");
        }
        System.out.println();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + "\t");
        }
        System.out.println();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(n);
        inputStream.reset();
        while ((c = inputStream.read()) != -1) {
            outputStream.write(Character.toLowerCase(c));
        }
        System.out.println("将 " + name + " 中的大写字母转为小写： " + outputStream.toString());
        outputStream.close();
        inputStream.close();
    }

    /**
     * 测试具体被装饰者PipedInputStream和PipedOutputStream
     * <p>如果要发生死锁，有个条件：PipedInputStream先调read方法读取数据，PipedOutputStream在调write方法写入数据</p>
     */
    @Test
    public void testPiped() throws IOException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        inputStream.connect(outputStream);

        String data = "f"; // 本程序中，如果data的字符数只有等于1的时候才会死锁，如果大于1，就不会死锁，因为第一次调用read方法读数据时只读了一个字节，后面再调read时有数据返回，所以不会产生死锁
        System.out.println("单线程中，PipedOutputStream先调write方法往管道中写数据，PipedInputStream再调read方法从管道中读数据：");
        System.out.println("PipedOutputStream开始写入数据: " + data);
        outputStream.write(data.getBytes());
        int read = inputStream.read();
        System.out.println("PipedInputStream收到数据: " + read);

        System.out.println("单线程中，PipedInputStream先调read方法从管道中读数据，PipedOutputStream先调write方法往管道中写数据：\n已发生死锁...");
        int read2 = inputStream.read();
        System.out.println("PipedInputStream收到数据: " + read2);
        System.out.println("PipedOutputStream开始写入数据: " + data);
        outputStream.write(data.getBytes());

        inputStream.close();
        outputStream.close();
    }

    /**
     * 压制异常，所有操作结束后，判断异常是否为null，来决定是否抛出
     * @throws Exception
     */
    @Test
    public void testException() throws Exception {
        Exception exception = null;
        try {
            try {
                throw new NullPointerException("1");
            } catch (Exception e) {
                if (exception == null) {
                    exception = e;
                } else {
                    exception.addSuppressed(e);
                }
            }
            throw new IndexOutOfBoundsException("2");
        } catch (Exception e) {
            if (exception == null) {
                exception = e;
            } else {
                exception.addSuppressed(e);
            }
        }finally {
            if (exception != null) {
                throw exception;
            }
        }
    }


}
