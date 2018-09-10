package com.tuyu.innerclass;

import org.junit.Test;

/**
 * 匿名内部类测试
 *
 * @author tuyu
 * @date 9/5/18
 * Talk is cheap, show me the code.
 */
public class AnonymousInner {

    public static void main(String[] args) throws InterruptedException {


//        long start1 = System.nanoTime();
//        for (int i = 0; i < 100; i++) {
//            Thread.currentThread().sleep(2L);
//        }
//        long end1 = System.nanoTime() - start1;
//        System.out.println(end1);
//
//        long start2 = System.currentTimeMillis();
//        for (int i = 0; i < 100; i++) {
//            Thread.currentThread().sleep(2L);
//        }
//        long end2 = System.currentTimeMillis() - start2;
//        System.out.println(end2);

//        int num = 10;
//        class Inner{
//            int n;
//            public Inner(int n) {
//                this.n = n;
//            }
//            public void show() {
//                System.out.println(n);
//            }
//        }
//
//        for (int i = 1; i < 2; i++) {
//            new Inner(i).show();
//            new Runnable(){
//                @Override
//                public void run() {
//                }
//            };
//        }
    }

    @Test
    public void test() {
        System.out.println(-1 << 29);
        System.out.println(0 << 29);
        System.out.println(1 << 29);
        System.out.println(2 << 29);
        System.out.println(3 << 29);

        System.out.println(Long.toBinaryString(2));
        System.out.println(Integer.toBinaryString(-1 << 29));
        System.out.println(Integer.toBinaryString(-1 << 29).length());
    }
}
