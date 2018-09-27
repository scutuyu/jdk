package com.tuyu.reflect;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
@Data
public class Teacher extends People  implements Serializable{

    private static final long serialVersionUID = 1L;

    private int age;

    public Teacher(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name=" + super.getName() +
                ", age=" + age +
                '}';
    }
}
