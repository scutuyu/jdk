package com.tuyu.clone;

import lombok.Data;

/**
 * Person没有实现Cloneable接口
 * @author tuyu
 * @date 7/18/18
 * Stay Hungry, Stay Foolish.
 */
@Data
public class PersonNotImplCloneable {

    private String name;
    private int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
