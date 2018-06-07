package com.tuyu.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

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

}
