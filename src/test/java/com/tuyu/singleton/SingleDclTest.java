package com.tuyu.singleton;

import com.tuyu.singleton.multi.SingleDcl;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * 测试双锁检查实现的单例对象在反序列化后的唯一性
 * <pre>
 *     写文件有三种方式，性能依次降低：FileWriter > BufferedOutputStream > FileOutputStream，
 *     但是FileWriter、BufferedOutputStream和FileOutputStream都没有writeObject方法,
 *     只有ObjectOutputStream类有writeObject方法
 * </pre>
 *
 *
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class SingleDclTest {

    @Test
    public void testDcl() throws IOException, ClassNotFoundException {
        // 获取单例对象
        SingleDcl instance = SingleDcl.getInstance();
        // 将单例对象写入磁盘文件
        String fileName = "src/test/resources/single_dcl";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(instance);

        // 再读文件
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        SingleDcl instance2 = (SingleDcl) ois.readObject();

        // 反序列化后的对象和之前获取的单例对象不是同一个对象
//        Assert.assertNotEquals(instance, instance2);
        System.out.println("instance == instance2 ? " + (instance == instance2));
    }
}
