package com.thread;

public class ThreadLocalDemo {

    private static ThreadLocal<Integer> seqCount = new ThreadLocal<Integer>(){
        /**
         * 实现 initialValue 方法
         */
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int nextSeq(){
        seqCount.set(seqCount.get()+1);
        return seqCount.get();
    }

    public void removeSeq(){
        seqCount.remove();
    }

    public static void main(String[] args) {
        ThreadLocalDemo seqCount = new ThreadLocalDemo();
        SeqThread thread1 = new SeqThread(seqCount);
        SeqThread thread2 = new SeqThread(seqCount);
        SeqThread thread3 = new SeqThread(seqCount);
        SeqThread thread4 = new SeqThread(seqCount);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private static class SeqThread extends Thread{
        private ThreadLocalDemo threadLocalDemo;

        SeqThread(ThreadLocalDemo threadLocalDemo){
            this.threadLocalDemo = threadLocalDemo;
        }

        @Override
        public void run() {
            for(int i = 0 ; i < 3 ; i++){
                System.out.println(Thread.currentThread().getName() + " seqCount :" + threadLocalDemo.nextSeq());
            }
            threadLocalDemo.removeSeq();
        }
    }
}
