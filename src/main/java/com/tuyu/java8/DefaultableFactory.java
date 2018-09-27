package com.tuyu.java8;

import java.util.function.Supplier;

/**
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public interface DefaultableFactory {

    /** java8新特性，接口中可以声明静态方法 */
    static Defaultable create(Supplier<Defaultable> supplier) {
        return supplier.get();
    }
}
