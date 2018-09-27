package com.tuyu.serial.exteral;

import lombok.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

/**
 * <pre>
 *     java提供了两种实现序列化和反序列化的方式：让类实现Serializable接口或者Externalizable接口，
 *     区别是，Serializable接口是一个标致接口，不需要实现具体的方法，
 *     而Externalizable接口有两个方法readExternal和writeExternal方法，具体的序列化和反序列换逻辑
 *     需要在这两个方法中实现
 * </pre>
 * <pre>
 *     相比较Serializable, Externalizable序列化、反序列更加快速，占用相比较小的内存,
 *     但是类必须提供无参构造函数，否则在反序列化时报InvalidClassException异常
 *
 * </pre>
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
@Data
public class Book implements Externalizable {
    private static final long serialVersionUID = 1L;

    private static int count = 10;

    /**书名*/
    private String name;

    /**ISBN*/
    private String isbn;

    /**作者*/
    private List<String> authors;

    // 如果使用Exteralizable序列化，则必须提供无参构造函数，否则在反序列化时会报InvalidClassException
    public Book() {
    }

    public Book(String name, String isbn) {
        this.name = name;
        this.isbn = isbn;
    }

    public void setCount(int count) {
        Book.count = count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                ", count=" + Book.count +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(count);
        out.writeObject(name);
        out.writeObject(isbn);
        out.writeObject(authors);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        count = (int) in.readObject();
        name = (String) in.readObject();
        isbn = (String) in.readObject();
        authors = (List<String>) in.readObject();
    }
}
