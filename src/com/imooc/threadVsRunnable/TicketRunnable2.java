package com.imooc.threadVsRunnable;

public class TicketRunnable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadNew1 mtn1=new MyThreadNew1();
		MyThreadNew1 mtn2=new MyThreadNew1();
		MyThreadNew1 mtn3=new MyThreadNew1();
		// ����3���̣߳�ģ��3��������Ʊ
		Thread mt1 = new Thread(mtn1,"����1");
		Thread mt2 = new Thread(mtn2,"����2");
		Thread mt3 = new Thread(mtn3,"����3");
		
		mt1.start();
		mt2.start();
		mt3.start();
	}
	
}

class MyThreadNew1 implements Runnable {
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