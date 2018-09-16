package com.tuyu.singleton.multi;

/**
 * 单例-单实例枚举
 * <pre>
 *     懒加载，类初始化块，首次获取慢，线程安全
 *     线程安全以及唯一性和静态内部类一样由JVM保证
 * </pre>
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class SingleEnum {

    public static SingleEnum getInstance(){
        return SingleHolderEnum.INSTANCE.getInstance();
    }

    private SingleEnum() {
    }

    private enum SingleHolderEnum{
        // INSTANCE常量只会被实例化一次，
        // 也就是说SingleHolderEnum的构造函数只会被执行一次，所以确保了单例的唯一性
        // JVM保证了单例的线程安全，因为SingleHolderEnum枚举只会被一个线程实例化一次
        INSTANCE;
        private SingleEnum instance;

        SingleHolderEnum() {
            this.instance = new SingleEnum();
        }
        public SingleEnum getInstance() {
            return instance;
        }
    }


    // 为了让反序列化后不会创建新的对象，需要提供readResolve方法
    public Object readResolve() {
        return getInstance();
    }
}
