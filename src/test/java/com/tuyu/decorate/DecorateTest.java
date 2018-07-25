package com.tuyu.decorate;

import org.junit.Test;

/**
 * 装饰者模式测试
 * <pre>
 *     装饰者模式让被装饰者的功能得到了增强，装饰者与具体的被装饰者实现了同样的接口，
 *     装饰者在调用被装饰者方法之前，会添加自己的增强逻辑
 * </pre>
 *
 * @author tuyu
 * @date 7/25/18
 * Talk is cheap, show me the code.
 */
public class DecorateTest {

    @Test
    public void testDecorate() {
        Component component = new ConcreteDecorator(new Impl());
        String s = component.sayHello();
        System.out.println(s);
    }
}
