package com.tuyu.java8.extendannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * java8新特性，扩展注解，新增两个元素类型,ElementType.TYPE_USE和ElementType.TYPE_PARAMETER
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class ExtendAnnotation {

    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @interface NotEmpty{

    }

    /** 泛型使用注解@ExtendAnnotation.NotEmpty，父类或接口使用注解@ExtendAnnotation.NotEmpty */
    static class Holder<@NotEmpty T> extends @NotEmpty Object {

        // 异常使用注解@ExtendAnnotation.NotEmpty
        public void method() throws @NotEmpty Exception {

        }

    }
}
