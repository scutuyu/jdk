package com.tuyu.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * CGLib动态代理
 *
 * @author tuyu
 * @date 2/24/19
 * Talk is cheap, show me the code.
 */
public class CglibProxy {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        Hello target = new Hello();
        Hello hello = newProxyInstance(target);
        // 调用代理对象的相应方法
        hello.sayHello();
//        // 调用包内可见的方法
//        hello.packageDefaultMethodSayHello();
//        // 调用protected修饰的方法
//        hello.protectedMethodSayHello();
//        // 调用private修饰的方法
//        hello.privateMethodSayHello();
//        // 调用final修饰的方法，此方法不能被代理类代理，因为final修饰的方法不能被子类重写，所以不能被CGLIB代理
//        hello.finalMethodSayHello();

        // 打印代理类对象信息
//        System.out.println("after proxy instance invoked successful, I can analyse the proxy instance: ");
//        System.out.println("proxy class's Class: " + hello.getClass().getName());
//        System.out.println("proxy class's super Class: " + hello.getClass().getSuperclass().getName());
//        System.out.println("proxy class's interfaces: " + Arrays.toString(hello.getClass().getInterfaces()));
        // 将代理对象写入二进制文件
//        String name = hello.getClass().getName();
//        writeObject(hello, name.substring(name.lastIndexOf(".") + 1));


    }

    private static void writeObject(Object object, String fileName) throws IOException {
        final String path = "src/main/resources/";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + fileName + ".class"));
        oos.writeObject(object);
        oos.flush();
        oos.close();
    }


    /**
     * 父类一定不要是private修饰的，否则无法创建代理子类
     */
    static class Hello{
        public void sayHello(){
            System.out.println("in Hello class public method: hello");
        }
//
//        void packageDefaultMethodSayHello() {
//            System.out.println("in Hello class package default method: hello");
//        }
//
//        protected void protectedMethodSayHello() {
//            System.out.println("in Hello class protected method: hello");
//        }
//
//        private void privateMethodSayHello() {
//            System.out.println("in Hello class private method: hello");
//        }
//
//        public final void finalMethodSayHello() {
//            System.out.println("in Hello class final method: hello");
//        }
    }

    private static class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("before invoke real method, I can do some log or security check");
            // 如果是调用代理对象的方法呢，就要调用proxy的invokeSuper，如果是要调用被代理类的方法呢，就要要用target的invoke
//            Object result = proxy.invoke(target, args);
            // 这里没有保存target的引用，所以就要采用下面的方式
            Object result = proxy.invokeSuper(obj, args);
            System.out.println("after invoke real method, I can do some data check");
            return result;
        }
    }

    private static Hello newProxyInstance(Object target) {
        System.getProperties().setProperty("cglib.debugLocation", "/Users/tuyu/Desktop/test/learn-jdk/target/classes");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MyMethodInterceptor());
        Hello o = (Hello) enhancer.create();
        return o;
    }
}
