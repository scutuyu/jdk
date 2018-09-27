package com.tuyu.serial;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

/**
 * 实现了Serializable的类，在序列化时会自动序列化所有非transient属性和非static属性，
 * 在反序列化时也会自动反序列化所有非transient属性和非static属性
 * 如果想自定义序列化逻辑需要添加readObject和writeObject方法，都是private void的
 * 参数分别是ObjectInputStream和ObjectOutputStream
 * <pre>
 *     为一个实现序列化的父类，编写一个能够序列化的子类，子类
 *     将自动实现序列化；反之，为一个没有实现序列化的父类，编写一个
 *     能够序列化的子类，子类要实现序列化的接口，并且父类需要提供一个
 *     无参构造函数，子类通过readObject和writeObject自己实现父类状态的序列化
 * </pre>
 * @author tuyu
 * @date 9/17/18
 * Talk is cheap, show me the code.
 */
@Data
public class Teacher extends People
//        implements Serializable/
{
    private static final long serialVersionUID = 1L;

    private static int count = 10;

    private String name;
    private int age;
//    private String hobby;
    private String address;

    public Teacher(String name, int age) {
        super("male");
        this.name = name;
        this.age = age;
    }

    public void setCount(int count) {
        Teacher.count = count;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
//                ", hobby='" + hobby + '\'' +
                ", count=" + Teacher.count +
                '}';
    }

    // 想要自定义序列化过程，需要提供私有的writeObject方法，返回值是void，参数是ObjectOutputStream
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(Teacher.count);
    }

    // 想要自定义反序列化过程，需要提供私有的readObject方法，返回值是void，参数是OjbectInputStream
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        Teacher.count = (int) inputStream.readObject();
    }

}
