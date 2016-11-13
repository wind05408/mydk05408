package com.dk.test.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by dk05408 on 2016-11-13.
 */
public class SemaphoreDemo4 {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors
            .newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10,true);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int number = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data "+number+" availablePermits"+s.availablePermits()+"  "+s.getQueueLength());
                        s.release();
                    } catch (InterruptedException e) {
                    }
                }
            });
        }

        threadPool.shutdown();
    }
}
