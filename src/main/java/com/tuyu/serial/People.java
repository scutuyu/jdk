package com.tuyu.serial;

import java.io.Serializable;

/**
 * @author tuyu
 * @date 9/17/18
 * Talk is cheap, show me the code.
 */
public class People implements Serializable{

    private String sex;

//    public People() {
//    }

    public People(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
