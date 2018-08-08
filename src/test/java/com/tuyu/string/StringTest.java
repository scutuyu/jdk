package com.tuyu.string;

import org.junit.Test;

import java.util.Objects;

/**
 * @author tuyu
 * @date 8/3/18
 * Talk is cheap, show me the code.
 */
public class StringTest {
    @Test
    public void test() {

        String a = "abc";
        final String b = a;
        String c = "dd";
        String d = b + c;
        System.out.println(d == "abcdd");
    }

    @Test
    public void testIntern() {
        String a = "a";
        String b = "b";
        String c = "c";
        String ab = "a" + "b";
        String ab1 = a + "b";
        String abc = "a" + "b" + "c";
        String bc1 = b + "c";
        System.out.println(bc1 == "bc");
        System.out.println(Objects.toString(bc1));
//        String abc1 = ab1 + "c";
//        System.out.println(abc);
//        String e = "abc";

    }
}
