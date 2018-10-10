package com.cg.project.threadwork;

public class RunnableResource implements Runnable{
	@Override
	public void run() {
		try {
			Thread t = Thread.currentThread();
			if(t.getName().equals("abc"))
				for(int i=1;i<=10;i++){
					System.out.println("*="+i);

					Thread.sleep(1000);
				}
		 
		
			if(t.getName().equals("pqr"))
				for(int i=1;i<=10;i++){
					System.out.println("@="+i);
					Thread.sleep(1000);
				}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}