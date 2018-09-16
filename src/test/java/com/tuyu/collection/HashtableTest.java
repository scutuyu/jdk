package com.tuyu.collection;

import org.junit.Test;

import java.util.Hashtable;
import java.util.Map;

/**
 * <pre>
 *     1. Hashtable不允许value为空，同样不允许key为空，
 *     虽然没有直接对key进行判断，但是在put和get方法里都会调用key的hashcode方法，
 *     如果key为空，将直接抛出NullPointerException
 *     2. Hashtable的构造函数默认将hash桶的容量设置为11,负载因子设为0.75
 *     3. 在put方法调用时，如果key已经存在了，就会执行替换，如果不存在，会判断count是否大于等于阀值，
 *     如果大于阀值，将会扩容，新的hash桶的大小时旧桶的两倍加一，并且遍历旧桶中的所有元素，采用头插法将数据插入新桶
 *     4. 散列的过程中，直接取key的hashcode值，并与桶的大小取模
 * </pre>
 * @author tuyu
 * @date 9/13/18
 * Talk is cheap, show me the code.
 */
public class HashtableTest {


    @Test
    public void testHashtable() {
        Map<String, Object> map = new Hashtable<>();

        map.put("null", 123);

    }

    @Test
    public void testNumber() {
        int num = tableSizeFor(0);
        System.out.println(num);
    }


    static final int tableSizeFor(int cap) {
        int MAXIMUM_CAPACITY = 1 << 30;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
