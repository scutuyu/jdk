package com.tuyu.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

/**
 * @author tuyu
 * @date 9/17/18
 * Talk is cheap, show me the code.
 */
public class Teacher extends People implements Serializable{
    private static final long serialVersionUID = 1L;

    private transient String name;
    private transient int age;
    private String hobby;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    //    private void writeObject(ObjectOutputStream outputStream) throws IOException {
//        outputStream.defaultWriteObject();
//
//        outputStream.writeObject(name);
//        outputStream.write(age);
//    }
//
//    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
//        inputStream.defaultReadObject();
//
//        this.name = inputStream.readObject().toString();
//        this.age = inputStream.readInt();
//    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("name"));
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = runtimeMxBean.getInputArguments();
        System.out.println(arguments);
    }
}
