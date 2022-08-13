package com.wishnoo.threading;

public class Application {

	public static void main(String[] args) {
		
		System.out.println("Starting Thread 1");
		Task taskRunner = new Task("Thread-A");
		Thread t1 = new Thread(taskRunner);
		t1.start();
		
		System.out.println("Starting Thread 2");
		Task taskRunner2 = new Task("Thread-B");
		Thread t2 = new Thread(taskRunner2);
		t2.start();
		
	}
}

class Task implements Runnable {
	
	private String name;
	
	public Task() {
		
	}
	public Task(String name) {
		this.name = name;
	}
	
	@Override
	public void run(){
		Thread.currentThread().setName(name);
		for(int i=0; i< 1000; i++) {
			System.out.println("number: " + i + " Name: " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}