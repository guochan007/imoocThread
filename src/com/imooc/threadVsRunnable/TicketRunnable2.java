package com.imooc.threadVsRunnable;

public class TicketRunnable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadNew1 mtn1=new MyThreadNew1();
		MyThreadNew1 mtn2=new MyThreadNew1();
		MyThreadNew1 mtn3=new MyThreadNew1();
		// 创建3个线程，模拟3个窗口卖票
		Thread mt1 = new Thread(mtn1,"窗口1");
		Thread mt2 = new Thread(mtn2,"窗口2");
		Thread mt3 = new Thread(mtn3,"窗口3");
		
		mt1.start();
		mt2.start();
		mt3.start();
	}
	
}

class MyThreadNew1 implements Runnable {
	// 一个5张票
	private int ticketCont = 5;
	// 窗口，即线程的名字
//	private String name;

//	public MyThread(String name) {
//		this.name = name;
//	}

	@Override
	public void run() {
		while (ticketCont > 0) {
			// 有票就卖1张
			ticketCont--;
			System.out.println(Thread.currentThread().getName() + "卖了1张，剩下" + ticketCont + "张");
		}
	}

}