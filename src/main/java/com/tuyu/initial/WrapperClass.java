package com.tuyu.initial;

/**
 * <p>
 *     参考：https://blog.csdn.net/Zerohuan/article/details/50015029
 * </p>
 * @author tuyu
 * @date 9/12/18
 * Talk is cheap, show me the code.
 */
public class WrapperClass {

    private static class A {
        static {
            System.out.println("类A初始化开始...");
        }
        //父类包含子类的static引用
//        private static B b = new B();
        private static B b;
        static {
            b = new B();
        }
        protected static int aInt = 9;

        static {
            System.out.println("类A初始化结束...");
        }

        public static void main(String[] args) {

        }

//        static {
//            b = new B();
//        }
    }

    private static class B extends A {
        static {
            System.out.println("类B初始化开始...");
        }
        //子类的域依赖于父类的域
        private static int bInt = 9 + A.aInt;


        private int b;

        {
            System.out.println("before initial b: " + b);
        }

        {
            b = 12;
        }

        {
            System.out.println("after initial b: " + b);
        }

        public B() {
            //构造器依赖类的static域
            System.out.println("类B的构造器调用 " + "bInt的值" + bInt);
        }

        static {
            System.out.println("类B初始化结束... " + "bInt的值：" + bInt);
        }

        public static void main(String[] args) {

        }
    }

}
