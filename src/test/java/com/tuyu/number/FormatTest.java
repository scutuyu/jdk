package com.tuyu.number;

import org.junit.Test;

/**
 * 基本数据类型的格式化输出
 * @author tuyu
 * @date 9/18/18
 * Talk is cheap, show me the code.
 */
public class FormatTest {

    /**
     * 浮点数格式化输出，位数，小数位数，对齐，占位，符号等
     */
    @Test
    public void testFormat() {
        float f = 12.23f;
        System.out.println("原数：" + f);
        System.out.println("> 确定输出位数1，如果输出大于9，按实际的输出，不够的补0，小数点占一位，小数点后3位：%01.3f");
        System.out.printf("%01.3f\n", f);

        System.out.println("> 确定输出位数9，如果输出大于9，按实际的输出，不够的补0，小数点占一位，小数点后3位：%09.3f");
        System.out.printf("%09.3f\n", f);


        System.out.println("> 确定输出位数9，如果输出大于9，按实际的输出，默认右对齐，左边空出来的就补空格，小数点后3位：%9.3f");
        System.out.printf("%9.3f\n", f);

        System.out.println("> 确定输出位数9，左对齐，默认右对齐，小数点后3位：%-9.3f");
        System.out.printf("%-9.3f\n", f);

        System.out.println("> 确定输出位数9，左对齐，默认右对齐，+输出数字的正负号，小数点后3位：%-9.3f");
        System.out.printf("%+9.3f\n", f);
    }

    /**
     * 正数格式化输出，十六进制，十进制，八进制，获取格式化参数
     */
    @Test
    public void testFormatInteger() {
        int i = 1234;
        System.out.println("原数：" + i);
        System.out.println("十六进制: %x");
        System.out.printf("%x\n", i);

        System.out.println("十六进制，带十六进制标志: %#x");
        System.out.printf("%#x\n", i);


        System.out.println("十进制: %d");
        System.out.printf("%d\n", i);

        System.out.println("八进制: %o");
        System.out.printf("%o\n", i);

        System.out.println("字符输出: %s");
        System.out.printf("%s\n", i);

        System.out.println("取第N个变量，N从1开始: N$");
        // 如果取的参数不存在，将抛出MissingFormatArgumentException
//        System.out.printf("%1$s, %2$d\n", i);
        System.out.printf("%1$s, %1$d\n", i);
    }
}
