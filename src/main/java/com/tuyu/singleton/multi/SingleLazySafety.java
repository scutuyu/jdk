package com.tuyu.singleton.multi;

/**
 * 单例-懒汉模式（线程安全)
 * <pre>
 *     懒加载，类初始化块，首次获取单例对象慢，线程安全，每次获取单例对象，都要进行同步，性能较差
 * </pre>
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class SingleLazySafety {
    private static SingleLazySafety instance;

    public static synchronized SingleLazySafety getInstance() {
        if (instance == null) {
            instance = new SingleLazySafety();
        }
        return instance;
    }

    private SingleLazySafety() {
    }

    // 为了让反序列化后不会创建新的对象，需要提供readResolve方法
    public Object readResolve() {
        return getInstance();
    }
}
