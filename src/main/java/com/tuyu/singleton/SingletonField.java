package com.tuyu.singleton;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Singleton</p>
 * 共有静态成员是final域
 * @author tuyu
 * @date 7/14/18
 * Stay Hungry, Stay Foolish.
 */
@Data
public class SingletonField implements Serializable{
    // 为了能序列化，需要实现Serializable接口
    private static final long serialVersionUID = 1L;

    public static final SingletonField INSTANCE = new SingletonField();

    private String name;
    private int age;

    private SingletonField(){
        // 为了防止反射创建实例，在创建第二个对象实例时抛出异常
        if (INSTANCE != null) {
            String msg = "can not create singleton object twice";
            System.out.println(msg);
            throw new RuntimeException(msg);
        }
    }

    // 为了保证反序列化时不会创建新的实例，需要添加readResolve方法，并将INSTANCE返回
    // 返回类型必须是Object,测试过程中我使用SingletonField，测试结果为新创建了实例
    public Object readResolve() {
        return INSTANCE;
    }

}
