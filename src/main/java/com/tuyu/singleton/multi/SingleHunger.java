package com.tuyu.singleton.multi;

/**
 * 单例-饿汉模式
 * <pre>
 *     类初始化较慢，获取单例对象较快，避免线程同步问题
 * </pre>
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class SingleHunger {

    private static SingleHunger instance = new SingleHunger();

    public static SingleHunger getInstance() {
        return instance;
    }

    private SingleHunger() {
    }

    // 为了让反序列化后不会创建新的对象，需要提供readResolve方法
    public Object readResolve() {
        return getInstance();
    }
}
