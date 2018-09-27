package com.tuyu.java8.annotation;

import java.lang.annotation.*;

/**
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class RepeatableAnnotation {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Repeatable(Filters.class)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filter{
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    @Filter("filter3")
    public interface Filterable{

    }


}
