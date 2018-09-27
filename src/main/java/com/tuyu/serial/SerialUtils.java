package com.tuyu.serial;

import java.io.*;

/**
 * 序列化工具
 * <p>参考链接：https://my.oschina.net/wangmengjun/blog/1588096</p>
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public final class SerialUtils {

    private SerialUtils(){}

    /** 序列化 */
    public static void serialize(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
    }

    /** 反序列化 */
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}
