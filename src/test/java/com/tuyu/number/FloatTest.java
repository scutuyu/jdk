package com.tuyu.number;

import org.junit.Test;

/**
 * 测试浮点型
 * <p>参考链接：https://akaedu.github.io/book/ch14s04.html</p>
 *
 * @author tuyu
 * @date 9/18/18
 * Talk is cheap, show me the code.
 */
public class FloatTest {

    /**
     * 打印单精度浮点型的二进制表示
     */
    @Test
    public void testFloat() {
        float f = 2.2f;
        printBinary(f);

        f = 5.2f;
        printBinary(f);

        f = 0.2f;
        printBinary(f);
    }

    /**
     * 打印双进度浮点型的二进制表示
     */
    @Test
    public void testDouble() {
        // java中的小数默认就是double类型
        double b = 0.2;
        printBinary(b);

        b = 7.2;
        printBinary(b);

        b = 22.2;
        printBinary(b);
    }

    private void printBinary(double b) {
        System.out.println("double = " + b);
        printBinary(Double.doubleToLongBits(b));
    }

    private void printBinary(long lo) {
        int zeroNum = Long.numberOfLeadingZeros(lo);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < zeroNum; i++) {
            stringBuilder.append(0);
        }
        stringBuilder.append(Long.toBinaryString(lo));
        System.out.println(stringBuilder);
    }

    private void printBinary(float a) {
        System.out.println("float = " + a);
        printBinary(Float.floatToIntBits(a));
    }

    private void printBinary(int a) {
        int zeroNum = Integer.numberOfLeadingZeros(a);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < zeroNum; i++) {
            stringBuilder.append(0);
        }
        stringBuilder.append(Integer.toBinaryString(a));
        System.out.println(stringBuilder);
    }

}
