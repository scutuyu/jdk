package com.tuyu.singleton.multi;

import java.io.Serializable;

/**
 * 单例-双锁检查
 * <pre>
 *     懒加载，类初始化块，首次获取单例对象慢，线程安全，使用轻量级的同步策略volatile,在初始化状态才需要同步初始化，同步开销低，
 *     低版本的JDK，volatile关键字的语义没有修改之前，线程不安全
 * </pre>
 *
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class SingleDcl implements Serializable{
    private static final long serialVersionUID = 1L;

    private static volatile SingleDcl instance;

    public static SingleDcl getInstance() {
        // 第一次判空
        if (instance == null) {
            synchronized (SingleLazySafety.class) {
                // 加锁同步后，第二次判空
                if (instance == null) {
                    // 使用volatile最轻量级的同步策略，保证instance变量的可见性，禁止下面代码的字节码指令重排序优化
                    instance = new SingleDcl();
                }
            }
        }
        return instance;
    }

    private SingleDcl() {
    }

    // 为了让反序列化后不会创建新的对象，需要提供readResolve方法
    public Object readResolve() {
        return getInstance();
    }
}
