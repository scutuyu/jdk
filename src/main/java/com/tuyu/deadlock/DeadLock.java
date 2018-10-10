package com.tuyu.deadlock;

import lombok.Data;

import java.util.Random;

/**
 * 死锁，动态顺序死锁，java并发编程实战，173页
 *
 * @author tuyu
 * @date 10/9/18
 * Talk is cheap, show me the code.
 */
public class DeadLock {

    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS = 1000000;

    private static final Object tieLock = new Object();

    public static void main(String[] args) {
        final Random random = new Random();
        Account[] accounts = new Account[NUM_ACCOUNTS];
        for (int i = 0; i < NUM_ACCOUNTS; i++) {
            accounts[i] = new Account(10000);
        }

        class TransferThread extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    int from = random.nextInt(NUM_ACCOUNTS);
                    int to = random.nextInt(NUM_ACCOUNTS);
                    transferMoney(accounts[from], accounts[to], random.nextInt(5));
                }
            }
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            new TransferThread().start();
        }
    }

    private static void transferMoney(Account fromAcc, Account toAcc, int num) {
        class Helper {
            public void transfer() {
                fromAcc.debit(num);
                toAcc.credit(num);
//                if (fromAcc.money < num) {
//                    throw new RuntimeException("your balance is not enough");
//                } else {
//                    fromAcc.debit(num);
//                    toAcc.credit(num);
//                    System.out.println(System.identityHashCode(fromAcc)
//                            + "("
//                            + fromAcc.getMoney()
//                            + ")"
//                            + " - "
//                            + System.identityHashCode(toAcc)
//                            + "("
//                            + toAcc.getMoney()
//                            + ")");
//                }
            }
        }
        int fromHash = System.identityHashCode(fromAcc);
        int toHash = System.identityHashCode(toAcc);
        if (fromHash < toHash) {
            synchronized (fromAcc) {
                synchronized (toAcc) {
                    new Helper().transfer();
                }
            }
        } else if (toHash < fromHash) {
            synchronized (toAcc) {
                synchronized (fromAcc) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAcc) {
                    synchronized (toAcc) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    @Data
    private static class Account {
        private int money;

        public Account() {
        }

        public Account(int money) {
            this.money = money;
        }

        public void debit(int num) {
            this.money -= num;
        }

        public void credit(int num) {
            this.money += num;
        }
    }
}
