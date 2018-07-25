package com.tuyu.bitset;

import org.junit.Test;

import java.util.BitSet;

/**
 * @author tuyu
 * @date 7/24/18
 * Talk is cheap, show me the code.
 */
public class BitSetTest {

    @Test
    public void testBitSet() {
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);//hashcode的值域
        System.out.println("bitSet.size: " + bitSet.size());
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        //0x7FFFFFFF
        String url = "http://baidu.com/a";
        int hashcode = url.hashCode() & 0x7FFFFFFF;
        bitSet.set(hashcode);

        System.out.println(bitSet.cardinality());//着色位的个数
        System.out.println(bitSet.get(hashcode));//检测存在性
        bitSet.clear(hashcode);//清除位数据
    }

    @Test
    public void test() {
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);

    }
}
