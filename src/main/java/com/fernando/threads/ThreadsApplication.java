package com.fernando.threads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadsApplication {


    //simulando um deadLock
    public static Integer count = 0;

    public static void main(String[] args) throws InterruptedException {

        //simulando um deadLock
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from a thread");
                for (int i = 0; i < 100; i++) {
                    count++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from a thread2");
                for (int i = 0; i < 100; i++) {
                    count++;
                }

            }
        });


        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();
        System.out.println(count);


        //        //criando nova thread
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
