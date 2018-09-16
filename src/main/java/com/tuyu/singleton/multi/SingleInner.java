package com.tuyu.singleton.multi;

import java.io.Serializable;

/**
 * 单例-静态内部类
 * <pre>
 *      懒加载，类初始化块，首次获取单例对象慢，线程安全,
 *      由JVM来保证单例对象的线程安全以及唯一性
 * </pre>
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class SingleInner implements Serializable{
    private static final long serialVersionUID = 1L;

    public static SingleInner getInstance() {
        // 在首次访问时，初始化静态内部类，
        // 由虚拟机保证类的初始化在多线程环境下被正确的加锁、同步，
        // 只有一个线程会执行SingleHelper类的<clinit>()方法，其他线程都会阻塞，
        // 当活动线程执行完SingleHelper类的<clinit>()方法后，其他线程不会在执行该方法，
        // 因为在同一个来加载器下，一个类只能被初始化一次
        return SingleHolder.instance;
    }

    private SingleInner() {
    }

    /** 静态内部类中的静态字段保存了外部类的实例对象 */
    private static class SingleHolder {
        private static SingleInner instance = new SingleInner();
    }
}
