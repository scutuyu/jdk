package com.tuyu.java8;

/**
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public interface Defaultable {

    /** java8新特性，接口可以声明默认方法 */
    default String notRequired() {
        return "Default implementation";
    }
}
