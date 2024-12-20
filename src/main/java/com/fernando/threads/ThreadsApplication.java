package com.fernando.threads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.locks.ReentrantLock;


@SpringBootApplication
public class ThreadsApplication {


    //simulando um deadLock
    public static Integer count = 0;


    //criando um retrantLock
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {


        Thread threadRetrantLock = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocal<Integer> threadLocalCounter = ThreadLocal.withInitial(() -> count);
                System.out.println("Hello from a thread");
                for (int i = 0; i < 100; i++) {
                    lock.lock();
                    try {
                        count++;
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        threadRetrantLock.start();

//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ThreadLocal<Integer> threadLocalCounter = ThreadLocal.withInitial(() -> count);
//                System.out.println("Hello from a thread");
//                for (int i = 0; i < 100; i++) {
//                    threadLocalCounter.set(threadLocalCounter.get() + 1);
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello from a thread2");
//                for (int i = 0; i < 100; i++) {
//                    count++;
//                }
//
//            }
//        });


//        thread1.start();
//        thread2.start();
//
//        System.out.println(count);
//
//        thread2.join();
//        thread1.join();


        //criando nova thread
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello from a thread");
//                throw new RuntimeException("Execuçao de thread");
//            }
//        });

//


//        //capturando execoes lançadas unchecked exception
//        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e){
//                System.out.println("erro");
//            }
//        });


    }

}
