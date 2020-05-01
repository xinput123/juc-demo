package com.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 假若一个工厂有5台机器，但是有10个工人，一台机器同时只能被一个工人使用，只有使用完了，其他工人才能继续使用
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        int workerNum = 10;
        final Semaphore semaphore = new Semaphore(5);
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < workerNum; i++) {
            final int j = i;
            executor.submit(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("工人"+j+"正在使用机器");
                    Thread.sleep(3000);
                    System.out.println("工人"+j+"释放机器");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
