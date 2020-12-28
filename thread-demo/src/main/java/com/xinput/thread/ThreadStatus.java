package com.xinput.thread;

import org.junit.Test;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @version 1.0
 * @date 2020/12/28 00:29
 * @description
 */
public class ThreadStatus {

  @Test
  public void blockTest() throws InterruptedException {
    Thread a = new Thread(new Runnable() {
      @Override
      public void run() {
        testMethod();
      }
    }, "a");

    Thread b = new Thread(new Runnable() {
      @Override
      public void run() {
        testMethod();
      }
    }, "b");

    a.start();
    Thread.sleep(1000L); // 需要注意这里main线程休眠了1000毫秒，而testMethod()里休眠了2000毫秒
    b.start();

    System.out.println(a.getName() + ":" + a.getState());
    System.out.println(b.getName() + ":" + b.getState());
  }

  // 同步方法争夺锁
  private synchronized void testMethod() {
    try {
      Thread.sleep(2000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
