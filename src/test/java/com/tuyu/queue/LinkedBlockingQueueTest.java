package com.tuyu.queue;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * LinkedBlockingQueue测试
 * <p>运行main函数之后，会提示输入一个路径，和一个关键字，程序会递归地扫描该路径下的所有文件，并将它们加入到阻塞队列中，
 *    另外两个线程会去队列中取数据，扫描文件，判断文件是否包含关键字，并打印出关键字所在的行</p>
 * <p>本例子来源于《Java核心技术》</p>
 * @author tuyu
 * @date 7/27/18
 * Talk is cheap, show me the code.
 */
public class LinkedBlockingQueueTest {

    private static int queueSize = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input a path:(eg: /Users/tuyu/Desktop/test/learn-jdk/src) ");
        String path = scanner.nextLine();
        System.out.println("please input a keyword:(eg:log)");
        String keyword = scanner.nextLine();

        BlockingQueue<File> queue = new LinkedBlockingDeque<>(queueSize);
        // 一个线程用于查询所有文件，将文件放入queue
        Thread enumThread = new Thread(new EnumThread(queue, path));
        enumThread.start();
        // 10个线程从queue中取出文件，扫描文件是否包含keyword
        for (int i = 0; i < 10; i++) {
            new Thread(new SearchThread(queue, keyword)).start();
        }
    }
}

class EnumThread implements Runnable{

    public static final File DUMMY = new File("");
    private BlockingQueue queue;
    private String path;

    public EnumThread(BlockingQueue queue, String path) {
        this.queue = queue;
        this.path = path;
    }

    @Override
    public void run() {
        File file = new File(path);
        try {
            enumFile(file);
            queue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enumFile(File file) throws InterruptedException {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    enumFile(f);
                }
            } else {
                queue.put(file);
            }
        }
    }
}

class SearchThread implements Runnable{

    private BlockingQueue<File> queue;
    private String keyword;
    private static boolean done = false;

    public SearchThread(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        File file = null;
        Scanner scanner = null;
        while (!done) {
            try {
                file = queue.take();
                System.out.println(Thread.currentThread().getName() + " get file from queue: " + file.getName());
                if (file == EnumThread.DUMMY) {
                    done = true;
                    break;
                }
                scanner = new Scanner(new FileInputStream(file));
                int count = 0;
                while (scanner.hasNextLine()) {
                    if (scanner.nextLine().contains(keyword)) {
                        System.out.println("find file " + file.getName() + " , line: " + count);
                    }
                    count ++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
