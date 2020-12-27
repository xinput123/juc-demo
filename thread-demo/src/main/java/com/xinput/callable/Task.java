package com.xinput.callable;

import java.util.concurrent.Callable;

/**
 * Callable与Runnable类似，同样是只有一个抽象方法的函数式接口。不同的是，Callable提供的方法是有返回值的，而且支持泛型。
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @version 1.0
 * @date 2020/12/27 22:27
 * @description Callable一般是配合线程池工具ExecutorService来使用的
 */
public class Task implements Callable<Integer> {

  private int num;

  public Task(int num) {
    this.num = num;
  }

  @Override
  public Integer call() throws Exception {
    // 模拟计算需要5s秒
    Thread.sleep(1000 * 5);
    return 3 * num;
  }
}
