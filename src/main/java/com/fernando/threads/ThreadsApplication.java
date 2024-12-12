package com.fernando.threads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadsApplication {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from a thread");
                throw new RuntimeException("Execuçao de thread");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from a thread2");
                throw new RuntimeException("Execuçao de thread");
            }
        });
        thread.start();


        //capturando execoes lançadas unchecked exception
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e){
                System.out.println("erro");
            }
        });
        thread2.start();
        System.out.println("hello world");


    }

}
