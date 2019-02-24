package com.tuyu.singleton;

/**
 * 通过idea创建类时的选项生成的单例模式
 * <p>
 *     此方法为饿汉模式
 * </p>
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class IdeaSingleton {
    // 私有静态属性， 声明时初始化
    private static IdeaSingleton ourInstance = new IdeaSingleton();

    // 提供公共静态方法，返回私有静态属性
    public static IdeaSingleton getInstance() {
        return ourInstance;
    }

    // 无参构造函数私有化
    private IdeaSingleton() {
    }
}
