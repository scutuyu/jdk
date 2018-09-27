package com.tuyu.reflect;

import lombok.Data;

/**
 * Teacher的父类
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
@Data
public class People {
    private String name;

    public People(String name) {
        this.name = name;
    }
}
