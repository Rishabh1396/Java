package com.cg.project.threadwork;

public class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		if(this.getName().equals("even"))
			for (int i = 0; i <= 100; i=i+2)
				System.out.println(i);
		if(this.getName().equals("odd"))
			for (int i = 1; i <= 100; i=i+2)
				System.out.println(i);
	}
}


