package com.tuyu.serial.exteral;

import com.tuyu.serial.SerialUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 测试 externalizable 的序列化和反序列化
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class BookTest {

    private static final String fileName = "src/test/resources/exteralizable_test";
    private Book book;

    @Before
    public void before() {
        book = new Book("Effective Java", "isbn");
        book.setCount(1000);
        book.setAuthors(Arrays.asList("hello", "world"));
        System.out.println("before: " + book);
    }

    @Test
    public void testSerialize() throws IOException {
        SerialUtils.serialize(book, fileName);
    }

    @Test
    public void testDeserialize() throws IOException, ClassNotFoundException {
        Object book = SerialUtils.deserialize(fileName);
        System.out.println("deserialize: " + book);
    }


}