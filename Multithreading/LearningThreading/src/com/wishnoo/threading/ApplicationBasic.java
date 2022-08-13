package com.wishnoo.threading;

public class ApplicationBasic {

	public static void main(String[] args) {
		
		System.out.println("Starting Thread 1");
		Thread t1 = new Thread(new Runnable()  {

			@Override
			public void run() {
//				Thread.currentThread().setName(name);
				for(int i=0; i< 1000; i++) {
					System.out.println("number: " + i + " Name: " + Thread.currentThread().getName());
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		
		System.out.println("Starting Thread 2");
		Thread t2 = new Thread(new Runnable()  {

			@Override
			public void run() {
//				Thread.currentThread().setName(name);
				for(int i=0; i< 1000; i++) {
					System.out.println("number: " + i + " Name: " + Thread.currentThread().getName());
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
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