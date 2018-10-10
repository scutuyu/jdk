package com.tuyu.jvm;

import java.util.ResourceBundle;

/**
 * JVM参数测试
 * 参考链接：https://cloud.tencent.com/developer/article/1082730
 * @author tuyu
 * @date 9/29/18
 * Talk is cheap, show me the code.
 */
public class JvmTest {

    private static final int _1M = 1024 * 1024;

    static class Hello{
        /**
         * -Xms20m：首先然让堆内存大小固定为20m
         * -Xmx20m
         * -Xmn10m：配置新生代内存10m
         * -XX:SurvivorRatio=8：配置survivor区大小1m
         * -XX:+UseSerialGC：新生代使用serial收集器，老年代使用serial old收集器
         * -XX:+PrintGCDetails：打印GC日志
         * <pre>
         *     client模式下，测试分配担保老年代的分配担保机制：
         *     1. 在Eden区先分配3个1M的数组
         *     2. 再分配1个4M的数组，Eden区内存不够，触发minorGC，
         *     将新生代所有存活对象转移到老年代，通过GC日志可以看到tenured generation占用6M的内存
         *
         * </pre>
        * @param args
         */
        public static void main(String[] args) {
            allocate();
        }

        private static void allocate() {
            byte[] b1 = new byte[2 * _1M];
            byte[] b2 = new byte[2 * _1M];
            byte[] b3 = new byte[2 * _1M];
            byte[] b4 = new byte[4 * _1M];
//[GC (Allocation Failure) [DefNewDisconnected from the target VM, address: '127.0.0.1:64316', transport: 'socket'
//: 7678K->553K(9216K), 0.0084415 secs] 7678K->6413K(19456K), 0.0084826 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
//            Heap
//            def new generation   total 9216K, used 4515K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
//            eden space 8192K,  48% used [0x00000007bec00000, 0x00000007befde4f8, 0x00000007bf400000)
//            from space 1024K,  54% used [0x00000007bf500000, 0x00000007bf58a7c0, 0x00000007bf600000)
//            to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
//            tenured generation   total 10240K, used 5859K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
//            the space 10240K,  57% used [0x00000007bf600000, 0x00000007bfbb8db0, 0x00000007bfbb8e00, 0x00000007c0000000)
//            Metaspace       used 2830K, capacity 4486K, committed 4864K, reserved 1056768K
//            class space    used 302K, capacity 386K, committed 512K, reserved 1048576K


//            [GC (Allocation Failure) [DefNew: 7963K->553K(9216K), 0.0052789 secs] 7963K->6697K(19456K), 0.0053007 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//            Heap
//            def new generation   total 9216K, used 4704K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
//            eden space 8192K,  50% used [0x00000007bec00000, 0x00000007bf00dbf8, 0x00000007bf400000)
//            from space 1024K,  54% used [0x00000007bf500000, 0x00000007bf58a7c0, 0x00000007bf600000)
//            to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
//            tenured generation   total 10240K, used 6144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
//            the space 10240K,  60% used [0x00000007bf600000, 0x00000007bfc00030, 0x00000007bfc00200, 0x00000007c0000000)
//            Metaspace       used 2830K, capacity 4486K, committed 4864K, reserved 1056768K
//            class space    used 302K, capacity 386K, committed 512K, reserved 1048576K
        }
    }


    static class Hello2{
        /**
         * vm参数:
         * -server：server模式运行
         * -Xms20m：堆内存固定为20m
         * -Xmx20m
         * -Xmn10m：新生代分配10m内存
         * -XX:SurvivorRatio=8：Eden区分配8m，Survivor区分配1m
         * -XX:+PrintGCDetails：打印GC日志
         * -XX:+UseParallelGC：新生代使用Parallel Scavenge收集器，老年代使用Serial Old收集器
         * <pre>
         *     Server模式下使用Parallel Scavenge + Serial Old收集器组合，测试老年代的分配担保机制，
         *     触发minorGC之后任然没有足够的内存，当分配对象的内存大于等于Eden区内存的一半，将直接在老年代分配
         *     1. Eden区先分配3个2M的数组
         *     2. 当再分配一个4M的数组时，4M等于Eden区内存的一半，将新生对象直接分配到老年代，不会触发minorGC,
         *     通过日志可以看到，并没有触发minorGc,在程序结束时打印了堆内存使用
         * </pre>
         * @param args
         */
        public static void main(String[] args) {
            allocate();
        }

        private static void allocate() {
            byte[] b1 = new byte[2 * _1M];
            byte[] b2 = new byte[2 * _1M];
            byte[] b3 = new byte[2 * _1M];
            byte[] b4 = new byte[4 * _1M];
//            Heap
//            PSYoungGen      total 9216K, used 8127K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
//            eden space 8192K, 99% used [0x00000007bf600000,0x00000007bfdefd48,0x00000007bfe00000)
//            from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
//            to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
//            ParOldGen       total 10240K, used 4096K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
//            object space 10240K, 40% used [0x00000007bec00000,0x00000007bf000010,0x00000007bf600000)
//            Metaspace       used 2829K, capacity 4486K, committed 4864K, reserved 1056768K
//            class space    used 302K, capacity 386K, committed 512K, reserved 1048576K
        }


    }

    static class Hello3{
        /**
         * vm参数:
         * -server：server模式运行
         * -Xms20m：堆内存固定为20m
         * -Xmx20m
         * -Xmn10m：新生代分配10m内存
         * -XX:SurvivorRatio=8：Eden区分配8m，Survivor区分配1m
         * -XX:+PrintGCDetails：打印GC日志
         * -XX:+UseParallelGC：新生代使用Parallel Scavenge收集器，老年代使用Serial Old收集器
         * <pre>
         *     Server模式下使用Parallel Scavenge + Serial Old收集器组合，测试老年代的分配担保机制
         *     触发minorGC之后任然没有足够的内存，当分配对象的内存小于Eden区内存的一半，弃用分配担保机制，将新生代的对象转移到老年代
         *     1. Eden区先分配3个2M的数组
         *     2. 当再分配一个3M的数组时，3M小于Eden区内存的一半，不会将新生对象直接分配到老年代
         *     3. 触发minorGC，但是没有对象被回收，因为jdk8默认开启分配担保机制，将把新生代所有存活的对象转移到老年代
         * </pre>
         * @param args
         */
        public static void main(String[] args) {
            allocate();
        }

        private static void allocate() {
            byte[] b1 = new byte[2 * _1M];
            byte[] b2 = new byte[2 * _1M];
            byte[] b3 = new byte[2 * _1M];
            byte[] b4 = new byte[3 * _1M];

//            [GC (Allocation Failure) [PSYoungGen: 7963K->672K(9216K)] 7963K->6824K(19456K), 0.0046247 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
//            [Full GC (Ergonomics) [PSYoungGen: 672K->0K(9216K)] [ParOldGen: 6152K->6697K(10240K)] 6824K->6697K(19456K), [Metaspace: 2824K->2824K(1056768K)], 0.0058446 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
//            Heap
//            PSYoungGen      total 9216K, used 3126K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
//            eden space 8192K, 38% used [0x00000007bf600000,0x00000007bf90dbf8,0x00000007bfe00000)
//            from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
//            to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
//            ParOldGen       total 10240K, used 6697K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
//            object space 10240K, 65% used [0x00000007bec00000,0x00000007bf28a420,0x00000007bf600000)
//            Metaspace       used 2831K, capacity 4486K, committed 4864K, reserved 1056768K
//            class space    used 302K, capacity 386K, committed 512K, reserved 1048576K
        }


    }

    static class Hello4{
        /**
         * vm参数:
         * -server：server模式运行
         * -Xms20m：堆内存固定为20m
         * -Xmx20m
         * -Xmn10m：新生代分配10m内存
         * -XX:SurvivorRatio=8：Eden区分配8m，Survivor区分配1m
         * -XX:+PrintGCDetails：打印GC日志
         * -XX:+UseParallelGC：新生代使用Parallel Scavenge收集器，老年代使用Serial Old收集器
         * @param args
         */
        public static void main(String[] args) {
            allocate();
        }

        private static void allocate() {
            byte[] b2 = new byte[4 * _1M];
//            byte[] b3 = new byte[2 * _1M];
//            byte[] b4 = new byte[2 * _1M];
//            byte[] b1 = new byte[9 * _1M];
        }
    }
    private static final String LSTRING_FILE = "javax.servlet.LocalStrings";
    private static ResourceBundle lStrings =
            ResourceBundle.getBundle(LSTRING_FILE);

    public static void main(String[] args) {
        System.out.println(lStrings);
        System.out.println();
    }
}
