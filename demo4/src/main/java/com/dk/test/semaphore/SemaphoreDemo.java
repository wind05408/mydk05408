package com.dk.test.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by dk05408 on 2016-11-12.
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(queue),"Thread"+i);
        }

        for(int i=0;i<10;i++){
            thread[i].start();
        }

    }

}

class  PrintQueue{
    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(1);
    }

    public void printJob(){
        try {
            semaphore.acquire();
            long duration = (long)(Math.random()*10);
            System.out.println(Thread.currentThread().getName()+"  PrintQueue   "+duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

class Job implements Runnable{
    private final PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s:Going to print a job\n", Thread.currentThread().getName());
        printQueue.printJob();
        System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());
    }
}

