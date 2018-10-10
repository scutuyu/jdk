package com.tuyu.md5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tuyu
 * @date 10/8/18
 * Talk is cheap, show me the code.
 */
public class Md5Test {
    static String string = "舟山市城市管理局（综合行政执法局）zstest12345618983117636hello worldfeCBRWt98";

    @Test
    public void test16() {
        String s = Md5.md5Encode16(string);
        System.out.println(s);
    }

    @Test
    public void test32() {
        String s = Md5.md5Encode32(string);
        System.out.println(s);
    }

}