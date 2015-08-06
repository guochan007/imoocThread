package com.imooc.threadVsRunnable;

public class TicketThread {

	public static void main(String[] args) {

		// 创建3个线程，模拟3个窗口卖票
		MyThread mt1 = new MyThread("窗口1");
		MyThread mt2 = new MyThread("窗口2");
		MyThread mt3 = new MyThread("窗口3");

		// 启动线程
		mt1.start();
		mt2.start();
		mt3.start();

//		结果是一共卖了15张票，没有共享ticketCont
	}

}

class MyThread extends Thread {
	// 一个5张票
	private int ticketCont = 5;
	// 窗口，即线程的名字
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (ticketCont > 0) {
			// 有票就卖1张
			ticketCont--;
			System.out.println(name + "卖了1张，剩下" + ticketCont + "张");
		}
	}

}