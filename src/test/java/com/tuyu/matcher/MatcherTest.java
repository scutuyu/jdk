package com.tuyu.matcher;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java中Pa
 * @author tuyu
 * @date 11/23/18
 * Talk is cheap, show me the code.
 */
public class MatcherTest {

    @Test
    public void testGroup() {

        Pattern pattern = Pattern.compile("(#\\{(.*?)\\})");
        Matcher matcher = pattern.matcher("#{}ddfd#{'hello world'}");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }
}
