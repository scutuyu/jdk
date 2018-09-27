package com.tuyu.java8.extendannotation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;


/**
 * 扩展注解测试
 *
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class ExtendAnnotationTest {

    @Test
    public void testExtendAnnotation() {
        ExtendAnnotation.Holder<String> holder = new ExtendAnnotation.Holder<>();
        // 局部变量使用注解@ExtendAnnotation.NotEmpty
        // 泛型使用注解@ExtendAnnotation.NotEmpty
        @ExtendAnnotation.NotEmpty Collection<@ExtendAnnotation.NotEmpty String> strings = new ArrayList<>();
    }

}