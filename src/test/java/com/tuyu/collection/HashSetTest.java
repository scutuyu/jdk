package com.tuyu.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class HashSetTest {

    @Test
    public void testHashSet() {
        Set<String> set = new HashSet<>();
        set.add(null);
        System.out.println(set);
    }
}
