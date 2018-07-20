package com.tuyu.singleton;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Singleton</p>
 * 单元素的枚举类型
 * @author tuyu
 * @date 7/14/18
 * Stay Hungry, Stay Foolish.
 */
public enum  SingletonEnum implements Serializable{
    INSTANCE,
    INSTANCE_2;
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SingletonEnum{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
