package com.tuyu.locksupport;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author tuyu
 * @date 9/5/18
 * Talk is cheap, show me the code.
 */
public class Main {
    CyclicBarrier barrier;

    List<Result> results = new ArrayList<Result>();

    static long timeConnect(String site) {
        long start = System.currentTimeMillis();
        try {
            new URL(site).openConnection().connect();
        } catch (IOException e) {
            return -1;
        }
        return System.currentTimeMillis() - start;
    }

    void showResults() {
        Collections.sort(results);
        for (Result result : results)
            System.out.printf("%-30.30s : %d\n", result.site, result.time);
        System.out.println("------------------");
    }

    public void start(String[] args) {
        Runnable showResultsAction = new Runnable() {
            public void run() {
                showResults();
                results.clear();
            }
        };
        barrier = new CyclicBarrier(args.length, showResultsAction);

        for (final String site : args)
            new Thread() {
                public void run() {
                    while (true) {
                        long time = timeConnect(site);
                        results.add(new Result(time, site));
                        try {
                            barrier.await(99, TimeUnit.SECONDS);
                        } catch (BrokenBarrierException e) {
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                }
            }.start();
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        new Main().start(new String[]{"www.baidu.com","www.youtube.com"});
    }
}

class Result implements Comparable<Result> {
    Long time;

    String site;

    Result(Long time, String site) {
        this.time = time;
        this.site = site;
    }

    public int compareTo(Result r) {
        return time.compareTo(r.time);
    }
}