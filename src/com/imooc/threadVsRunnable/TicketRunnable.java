package com.imooc.threadVsRunnable;

public class TicketRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadNew mt=new MyThreadNew();
		// ����3���̣߳�ģ��3��������Ʊ
		Thread mt1 = new Thread(mt,"����1");
		Thread mt2 = new Thread(mt,"����2");
		Thread mt3 = new Thread(mt,"����3");
		
		mt1.start();
		mt2.start();
		mt3.start();
	}
	
}

class MyThreadNew implements Runnable {
	// һ��5��Ʊ
	private int ticketCont = 5;
	// ���ڣ����̵߳�����
//	private String name;

//	public MyThread(String name) {
//		this.name = name;
//	}

	@Override
	public void run() {
		while (ticketCont > 0) {
			// ��Ʊ����1��
			ticketCont--;
			System.out.println(Thread.currentThread().getName() + "����1�ţ�ʣ��" + ticketCont + "��");
		}
	}

}