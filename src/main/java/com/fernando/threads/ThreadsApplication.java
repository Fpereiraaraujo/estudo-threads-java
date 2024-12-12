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
            }
		});
		thread.start();
		System.out.println("hello threads");

	}

}
