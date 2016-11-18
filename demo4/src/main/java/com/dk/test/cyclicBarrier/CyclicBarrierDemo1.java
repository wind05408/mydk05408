package com.dk.test.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dk05408 on 2016-11-13.
 * CyclicBarrier就是一个拦截器，当满足条件时，就放行。而这个条件就是CyclicBarrier初始化的number计数。
 * 就是一组数据在等待，当达到number数量时，放行。
 */
public class CyclicBarrierDemo1 {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new Thread(new Runner(barrier,"zhangSan")));
        executorService.submit(new Thread(new Runner(barrier,"LiSi")));
        executorService.submit(new Thread(new Runner(barrier,"wangWu")));
        executorService.submit(new Thread(new Runner(barrier,"zhaoLiu")));

        executorService.shutdown();
    }
}

class Runner implements Runnable{

    private CyclicBarrier barrier;
    private String name;

    public Runner(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * (new Random()).nextInt(8));
            System.out.println(name + " 准备好了...");
            // barrier的await方法，在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 起跑！");

    }
}