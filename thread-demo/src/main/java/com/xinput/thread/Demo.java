package com.xinput.thread;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @version 1.0
 * @date 2020/12/27 23:53
 * @description
 */
public class Demo {
  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
    });
    System.out.println(thread.getState());
  }
}
