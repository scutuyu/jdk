package com.tuyu.decorate;

/**
 * 具体是实现者
 * @author tuyu
 * @date 7/25/18
 * Talk is cheap, show me the code.
 */
public class Impl implements Component {
    @Override
    public String sayHello() {
        return "concrete implement 1";
    }
}
