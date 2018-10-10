package com.cg.project.threadwork;

public class MainClass {

	public static void main(String[] args) {
		/*MyThread even = new MyThread("even");
		MyThread odd = new MyThread("odd");
		even.start();
		odd.start();*/
		//RunnableResource r1=new RunnableResource();
		//Thread th1 = new Thread(r1,"abc");
		//Thread th2 = new Thread(r1,"pqr");
		//th1.start();
		Runnable runnableResource = ()->{
			for(int i=0;i<10;i++)
				System.out.println("Tick "+i);
		};
		Thread th1 = new Thread(runnableResource);
		th1.start();
		
	}
}
