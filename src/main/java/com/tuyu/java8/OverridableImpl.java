package com.tuyu.java8;

/**
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class OverridableImpl implements Defaultable {

    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
