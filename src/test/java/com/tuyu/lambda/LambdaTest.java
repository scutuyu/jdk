package com.tuyu.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <pre>
 * ////////////////////////////////////////////////////////////////////
 * //                          _ooOoo_                               //
 * //                         o8888888o                              //
 * //                         88" . "88                              //
 * //                         (| ^_^ |)                              //
 * //                         O\  =  /O                              //
 * //                      ____/`---'\____                           //
 * //                    .'  \\|     |//  `.                         //
 * //                   /  \\|||  :  |||//  \                        //
 * //                  /  _||||| -:- |||||-  \                       //
 * //                  |   | \\\  -  /// |   |                       //
 * //                  | \_|  ''\---/''  |   |                       //
 * //                  \  .-\__  `-`  ___/-. /                       //
 * //                ___`. .'  /--.--\  `. . ___                     //
 * //              ."" '<  `.___\_<|>_/___.'  >'"".                  //
 * //            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
 * //            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
 * //      ========`-.____`-.___\_____/___.-`____.-'========         //
 * //                           `=---='                              //
 * //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
 * //             佛祖保佑       永无BUG     永不修改                   //
 * ////////////////////////////////////////////////////////////////////
 * </pre>
 * <p>
 * tuyu于5/31/18祈祷...
 * 常用的Lambda，Stream操作
 * <p>https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/index.html</p>
 * @author tuyu
 * @date 5/31/18
 * Stay Hungry, Stay Foolish.
 */
public class LambdaTest {
    
    Stream<String> stream = null;

    @Before
    public void before() {
        stream = Stream.of("String", "Hello", "World", "Tuyu", "oOOOO");
    }

    /**
     * filter 过滤
     * <p>去掉Hello</p>
     */
    @Test
    public void testFilter() {
        List<String> list = stream.filter(t -> !t.equals("Hello")) // 过滤
                .collect(Collectors.toList()); // 将stream转为List
        System.out.println(list);
    }

    /**
     * joining 字符拼接
     * <p>间隔为逗号，前缀是[,后缀是]</p>
     */
    @Test
    public void testJoin() {
        String string = stream.collect(Collectors.joining(",", "[", "]"));
        System.out.println(string);
    }

    /**
     * :: 双冒号运算符--就是方法调用
     */
    @Test
    public void testColon() {
        List<String> list = stream.map(String::toUpperCase) // 将每个字符串映射为大写
                .collect(Collectors.toList()); // 将Stream转为List
        System.out.println(list);
    }

    /**
     * map 一对一映射
     * <p>map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素</p>
     */
    @Test
    public void testMap() {
        List<String> collect = stream.map(t -> "*" + t + "*")
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * flatMap 一对多映射
     * <p>flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，
     * 最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字</p>
     */
    @Test
    public void testFlatMap() {
        Stream<List<Integer>> listStream = Stream.of(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> collect = listStream.flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * foreEach 每个元素执行一个函数
     */
    @Test
    public void testForeEach() {
        stream.forEach(System.out :: println);
    }

    /**
     * peek 和foreEach一样，但是它是intermediate操作，不是terminate操作
     * <p>执行了peek操作的Stream还可以继续进行intermediate操作或者terminate操作</p>
     * <pre>
     *   String
         String
         Hello
         World
         World
         Tuyu
         Tuyu
         oOOOO
         oOOOO
         [STRING, WORLD, TUYU, OOOOO]
     * </pre>
     */
    @Test
    public void testPeek() {
        List<String> hello = stream.peek(System.out::println)
                .filter(t -> !t.equals("Hello"))
                .peek(System.out::println)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(hello);
    }

    /**
     * findFirst
     */
    @Test
    public void testFindFirst() {
        Optional<String> first = stream.findFirst();
        System.out.println(first.get());
    }

    /**
     * ParallelStream
     * <p>将结果添加到List中</p>
     */
    @Test
    public void testParallel() {
        stream = stream.parallel();
        ArrayList<Object> collect = stream.collect(ArrayList::new, List::add, List::addAll);
        System.out.println(collect);
    }
}
