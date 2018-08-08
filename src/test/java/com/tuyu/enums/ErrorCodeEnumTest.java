package com.tuyu.enums;

import org.junit.Test;

/**
 * 测试枚举数组的clone方法，克隆出来的数组，元素是否是同一个元素
 *
 * @author tuyu
 * @date 8/7/18
 * Talk is cheap, show me the code.
 */
public class ErrorCodeEnumTest {

    @Test
    public void testArrayClone() {
        ErrorCodeEnum[] arr = new ErrorCodeEnum[]{ErrorCodeEnum.SUCCESS, ErrorCodeEnum.PARAM_EMPTY};

        ErrorCodeEnum[] clone = arr.clone();

        System.out.println(arr[0] == clone[0]);


        String[] s1 = new String[]{"hello", "world"};
        String[] clone1 = s1.clone();
        System.out.println(s1[0] == clone1[0]);


    }
}
