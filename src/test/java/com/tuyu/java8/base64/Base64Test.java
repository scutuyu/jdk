package com.tuyu.java8.base64;

import com.sun.xml.internal.txw2.TXW;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * java8新特性，base64支持
 *
 * @author tuyu
 * @date 9/28/18
 * Talk is cheap, show me the code.
 */
public class Base64Test {

    private static final String text = "hello world, my name is tuyu";
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    @Test
    public void testEnCode() {
        String encode = encode(text);
        System.out.println(encode);
        System.out.println(decode(encode));
    }

    private String encode(String text) {
        return Base64.getEncoder()
                .encodeToString(text.getBytes(CHARSET));
    }

    private String decode(String text) {
        return new String(Base64.getDecoder()
                .decode(text), CHARSET);
    }
}
