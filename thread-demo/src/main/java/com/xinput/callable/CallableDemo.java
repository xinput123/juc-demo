package com.xinput.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @version 1.0
 * @date 2020/12/27 22:29
 * @description
 */
public class CallableDemo {
  public static void main(String[] args) {
    // 使用
    ExecutorService service = Executors.newCachedThreadPool();
    Task task = new Task(10);
    Future<Integer> result = service.submit(task);
    // 注意调用get会阻塞当前线程，直到得到结果。
    // 所以实际编码中建议使用可以设置超时时间的重载get方法
//    System.out.println(result.get());
    Integer integer = null;
    while (true) {
      try {
        integer = result.get(1, TimeUnit.SECONDS);
        if (integer != null) {
          break;
        }
      } catch (TimeoutException e) {
        System.out.println("timeout");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    System.out.println(integer);
  }
}
