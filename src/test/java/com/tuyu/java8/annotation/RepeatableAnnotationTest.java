package com.tuyu.java8.annotation;

import org.junit.Test;

import javax.annotation.processing.Filer;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * java8新特性，重复注解测试
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class RepeatableAnnotationTest {

    @Test
    public void testRepeatableAnnotation() {

        RepeatableAnnotation.Filter[] filters = RepeatableAnnotation.Filterable.class
                .getAnnotationsByType(RepeatableAnnotation.Filter.class);
        Arrays.asList(filters)
                .stream()
                .map(RepeatableAnnotation.Filter::value)
                .forEach(System.out::println);
    }
}