package com.tuyu.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     1. HashMap允许key和value都为null
 *     2. 初始化HashMap的时候，采用延迟初始化hash桶，到调用put方法是才初始化
 *     3. 默认容量是16，默认负载因子是0.75，如果传入的初始容量不是2的N次方，会转化为比它大的最小的一个2的N次方
 *     4. 之所以要限定hash桶的容量是2的N次方，是为了提高取模的计算性能
 *     5. 另外计算key的hash值也不是简单的调用key的hashCode方法，如果key为null，hash值为0，key不为null，则
 *     将key的hashcode的高16位于低16位进行异或计算，以降低hash冲突
 *     6. 扩容的判断是在添加元素之后进行的，如果HashMap的大小大于等于阀值，就将容量扩大为原来的两倍，rehash时将采用头插法进行数据的转移
 *     7. 当添加元素发生hash碰撞时，如果hash桶中的节点数量大于阀值（默认是8），将将链表转为红黑树，提升查询的效率
 *     8. HashMap不是线程安全的，当一个线程在修改HashMap的结构，另一个线程在遍历HashMap，程序将抛出ConcurrentModificationException,
 *     当多个线程同时往HashMap中添加数据，容易在扩容时出现死循环或者数据不一致的情况，多线程下要同时操作一个Map，建议使用ConcurentHashMap
 * </pre>
 * @author tuyu
 * @date 9/13/18
 * Talk is cheap, show me the code.
 */
public class HashMapTest {


    @Test
    public void testHashMap() {
        Map<String, Object> map = new HashMap<>(0);

        map.put("helllo", "world");
        System.out.println();
    }
}
