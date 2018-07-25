package com.tuyu.decorate;

/**
 * @author tuyu
 * @date 7/25/18
 * Talk is cheap, show me the code.
 */
public abstract class AbstractDecorator implements Component{

    Component component;

    public AbstractDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String sayHello() {
        return this.getClass().getSimpleName() + ":" + component.sayHello();
    }
}
