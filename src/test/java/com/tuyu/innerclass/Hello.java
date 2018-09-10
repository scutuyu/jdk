package com.tuyu.innerclass;

/**
 * @author tuyu
 * @date 9/5/18
 * Talk is cheap, show me the code.
 */
public class Hello {
    private int num1 = 1;
    private static int num3 = 3;

    public void showOutter(){

        int num4 = 4;

        class Inner1{
            private int num2 = 2;

            public void showInner(){
                System.out.println(String.format("inner variable num2: %s", num2));
                System.out.println(String.format("method final variable num4: %s", num4));
                System.out.println(String.format("Hello variable num1: %s", num1));
                System.out.println(String.format("Hello static variable num3: %s", num3));
            }
        }

        Inner1 inner1 = new Inner1();
        inner1.showInner();

    }


    public static void main(String[] args) {
        new Hello().showOutter();
    }
}
