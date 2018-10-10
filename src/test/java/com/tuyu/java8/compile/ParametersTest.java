package com.tuyu.java8.compile;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * java8新特性，语言层面和JVM字节文件
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class ParametersTest {


    /**
     * <pre>
     *     编译com.tuyu.java8.compile.Parameters类
     *     1. cd src/main/java
     *     2. javac com/tuyu/java8/compile/Parameters.java -d ../../../target/classes/ -parameters
     *     3. 运行下面的测试类，将会输出
     *     name
     *     age
     *     4. 如果编译时不使用-parameters参数，运行下面的代码将会得到
     *     arg0
     *     arg1
     * </pre>
     * <pre>
     *     也可通过maven的配置，将参数-parameters加到编译器中去
     *     <plugin>
     *         <groupId>org.apache.maven.plugins</groupId>
     *         <artifactId>maven-compiler-plugin</artifactId>
     *         <version>3.1</version>
     *         <configuration>
     *             <compilerArgument>-parameters</compilerArgument>
     *             <source>1.8</source>
     *             <target>1.8</target>
     *         </configuration>
     *    </plugin>
     * </pre>
     * @throws NoSuchMethodException
     */
    @Test
    public void testParameterName() throws NoSuchMethodException {
        Method method = Parameters.class.getMethod("sayHello", String.class, int.class);
        Arrays.asList(method.getParameters())
                .stream()
                .map(Parameter::getName)
                .forEach(System.out::println);
    }

    @Test
    public void testIdentityHashCode() {
        Object object = new Object();
        System.out.println(object.hashCode());
        System.out.println(System.identityHashCode(object));
    }
}