package com.tuyu.serial;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 序列化测试类
 * <pre>
 *     1. 如果被序列化的类没有实现Serializable接口，将抛出NotSerializableException异常
 *     2. 如果类中没有指定serialVersionUID版本信息，编译器将根据类的情况自动生成，
 *     当反序列化时会比较两个版本是否相同，不相同就会报InvalidClassException异常，如：
 *     java.io.InvalidClassException: com.tuyu.serial.Teacher;
 *     local class incompatible: stream classdesc serialVersionUID = 6522917385636024008,
 *     local class serialVersionUID = 1586102286767065687
 *     此时，我们可以通过手动添加private static final long serialVersionUID = 1L的形式来避免这种异常
 *     3. 如果反序列化的类的父类没有提供无参构造函数，在反序列化时会抛出InvalidClassException: com.tuyu.serial.Teacher; no valid constructor
 * </pre>
 * @author tuyu
 * @date 9/17/18
 * Talk is cheap, show me the code.
 */
public class SerialTest {

    private static final Logger logger = LoggerFactory.getLogger(SerialTest.class);

    @Test
    public void testSerial() throws IOException, ClassNotFoundException {
        String fileName = "src/test/resources/serial_teacher";

        Teacher teacher = new Teacher("tuyu", 12);

        // 序列化
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
//        oos.writeObject(teacher);
//        oos.flush();
//        oos.close();

//        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Teacher teacher1 = (Teacher) ois.readObject();
        ois.close();

        logger.info("teacher: {}", teacher);
        logger.info("teacher1: {}", teacher1);
        logger.info("teacher == teacher1 ?{}", teacher == teacher1);

    }


    /**
     * Integer类默认会缓存-128~127之间的整数，
     * 可以通过参数-Djava.lang.Integer.IntegerCache.high=500设置缓存的最大值
     */
    @Test
    public void test() {

//        String property = System.getProperty("java.lang.Integer.IntegerCache.high");
//
//        Integer i = Integer.valueOf(123);

        System.out.println(0.9f == 1f);
        System.out.println(0.99999999f == 1f);


        float f1 = 16777215f;
        for (int i = 0; i < 10; i++) {
            System.out.println(f1);
            f1++;

        }

        float f = 2.2f;
        double d = (double) f;
        System.out.println(d);
        f = 2.25f;
        d = (double) f;
        System.out.println(d);
    }



}
