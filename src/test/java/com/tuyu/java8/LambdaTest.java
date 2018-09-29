package com.tuyu.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class LambdaTest {

    @Test
    public void testLambda() {
        // lambda表达式由逗号分隔的参数列表+箭头符号+函数体组成
        // 参数列表: element
        // 箭头符号: ->
        // 函数体: System.out.println(element)
//        Arrays.asList(1, 2, 3, 4, 5).forEach(element -> System.out.println(element));
        // 可以写出参数的类型
//        Arrays.asList(1, 2, 3, 4, 5).forEach((Integer element) -> System.out.println(element));
        // 多个参数可以有括号包起来，并用逗号分隔
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // 倒序排列
        list.sort((e1, e2) -> e2.compareTo(e1));
        // 打印输出
        list.forEach(System.out::println);

        // lambda表达式引用局部变量，局部变量将被隐式转为final类型
        // 下面的代码等同于: final String separator = ",";
//        String separator = ",";
//        final String separator = ",";
//        Arrays.asList(1, 2, 3, 4, 5).forEach(element -> {
//            System.out.println(element + separator);
//        });

    }
}
