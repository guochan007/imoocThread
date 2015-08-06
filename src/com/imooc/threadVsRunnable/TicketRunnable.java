package com.imooc.threadVsRunnable;

public class TicketRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadNew mt=new MyThreadNew();
		// 创建3个线程，模拟3个窗口卖票
		Thread mt1 = new Thread(mt,"窗口1");
		Thread mt2 = new Thread(mt,"窗口2");
		Thread mt3 = new Thread(mt,"窗口3");
		
		mt1.start();
		mt2.start();
		mt3.start();
	}
	
}

class MyThreadNew implements Runnable {
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