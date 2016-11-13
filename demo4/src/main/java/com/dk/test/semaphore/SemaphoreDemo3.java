package com.dk.test.semaphore;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by dk05408 on 2016-11-13.
 */
public class SemaphoreDemo3 {
    final static int MAX_QPS = 4;
    final static Semaphore semaphore = new Semaphore(MAX_QPS);

    public static void main(String[] args) throws Exception {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                semaphore.release(MAX_QPS / 2);
            }
        }, 1000, 500, TimeUnit.MILLISECONDS);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 10; i > 0; i--) {
            final int x = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 10; j > 0; j--) {
                        semaphore.acquireUninterruptibly(1);
                        remoteCall(x, j);
                    }
                }
            });

        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("DONE");
    }

    private static void remoteCall(int i, int j) {
        System.out.println(String.format("%s - %s: %d %d", new Date(),
                Thread.currentThread(), i, j));
    }

}
