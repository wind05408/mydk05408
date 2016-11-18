package com.dk.test.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by dk05408 on 2016-11-13.
 */
public class CyclicBarrierDemo2 {
    public static void main(String[] args) throws Exception{
        CyclicBarrier barrier = new CyclicBarrier(2);
        System.out.println("begin");
        for (int i = 0; i <2 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        barrier.await();
                        System.out.println("test");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        System.out.println("frist end");

    }
}
