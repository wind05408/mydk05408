package com.dk.test.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dk05408 on 2016-11-13.
 */
public class CountDownLatchDemo1 {
    private static final CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            countDown();
        }
        latch.await();
        System.out.println("test");
    }

    private static void countDown(){
        latch.countDown();
        System.out.println("countDown");
    }
}
