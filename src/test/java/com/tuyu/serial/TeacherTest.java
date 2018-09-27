package com.tuyu.serial;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * 测试Serializable
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class TeacherTest {

    private static final String fileName = "src/test/resources/serialize_test";
    private Teacher teacher;

    @Before
    public void before() {
        teacher = new Teacher("tuyu", 12);
//        teacher.setHobby("youyong");
        teacher.setCount(100);
        System.out.println("before: " + teacher);
    }

    @Test
    public void testSerialize() throws IOException {
        SerialUtils.serialize(teacher, fileName);
    }

    @Test
    public void testDeserialize() throws IOException, ClassNotFoundException {
        Object teacher = SerialUtils.deserialize(fileName);
        System.out.println("deserialize: " + teacher);
    }
}