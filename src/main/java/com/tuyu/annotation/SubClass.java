package com.tuyu.annotation;

import com.tuyu.abstrac.AbstractHello;

/**
 * SubClass与AbstractHello在不同的包中，看SubClass能否访问父类的默认的访问修饰符的方法
 * @author tuyu
 * @date 10/16/18
 * Talk is cheap, show me the code.
 */
public class SubClass extends AbstractHello {

    public void sayHello() {
        // 不能访问父类默认修饰符的方法
//        super.myResolveClass();
        // 可以访问父类protected修饰的方法
        super.resolveClass();
    }
}
