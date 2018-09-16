package com.tuyu.singleton.multi;

/**
 * 单例-懒汉模式
 * <pre>
 *     懒加载，类初始化块，首次获取单例对象慢，线程不安全
 * </pre>
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class SingleLazy {
    private static SingleLazy instance;

    public static SingleLazy getInstance() {
        if (instance == null) {
            instance = new SingleLazy();
        }
        return instance;
    }

    private SingleLazy() {
    }

    // 为了让反序列化后不会创建新的对象，需要提供readResolve方法
    public Object readResolve() {
        return getInstance();
    }
}
