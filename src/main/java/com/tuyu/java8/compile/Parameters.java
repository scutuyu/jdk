package com.tuyu.java8.compile;

/**
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class Parameters {

    public void sayHello(String name, int age) {
        System.out.println("hello " + name + ", you are " + age + " years old");
    }

    public String concat(String s1, String s2, String s3){
        return s1 + s2 + s3;
    }
}
