package com.tuyu.synchronize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tuyu
 * @date 10/10/18
 * Talk is cheap, show me the code.
 */
public class SynchronizedTest {

    private final CyclicBarrier barrier;
    private final List<String> list;
    public SynchronizedTest() {
        list = Collections.synchronizedList(new ArrayList<String>());
        barrier = new CyclicBarrier(2,newBarrierAction());
    }
    public Runnable newThreadOne() {
        final String[] inputArr = Helper.buildNoArr(52);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                for (int i = 0, j=0; i < arr.length; i=i+2,j++) {
                    try {
                        list.add(arr[i]);
                        list.add(arr[i+1]);
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
    public Runnable newThreadTwo() {
        final String[] inputArr = Helper.buildCharArr(26);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                for (int i = 0; i < arr.length; i++) {
                    try {
                        list.add(arr[i]);
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
    private Runnable newBarrierAction(){
        return new Runnable() {
            @Override
            public void run() {
                Collections.sort(list);
                list.forEach(c->System.out.print(c));
                list.clear();
            }
        };
    }
    public static void main(String args[]){
//        SynchronizedTest four = new SynchronizedTest();
//        Helper.instance.run(four.newThreadTwo());
//        Helper.instance.run(four.newThreadOne());
//        Helper.instance.shutdown();
        System.out.println((int)'1');
        System.out.println((int)'9');
    }

}

enum Helper {

    instance;

    private static final ExecutorService tPool = Executors.newFixedThreadPool(2);

    public static String[] buildNoArr(int max) {
        String[] noArr = new String[max];
        for(int i=0;i<max;i++){
            noArr[i] = Integer.toString(i+1);
        }
        return noArr;
    }

    public static String[] buildCharArr(int max) {
        String[] charArr = new String[max];
        int tmp = 65;
        for(int i=0;i<max;i++){
            charArr[i] = String.valueOf((char)(tmp+i));
        }
        return charArr;
    }

    public static void print(String... input){
        if(input==null)
            return;
        for(String each:input){
            System.out.print(each);
        }
    }

    public void run(Runnable r){
        tPool.submit(r);
    }

    public void shutdown(){
        tPool.shutdown();
    }

}

