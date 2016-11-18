package com.dk.test.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by dk05408 on 2016-11-13.
 */
public class CyclicBarrierDemo3 {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new A());
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException |BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        }).start();
//        try {
//            cyclicBarrier.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }
//        System.out.println(2);

    }

    static class  A implements Runnable{
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
